package Chapter20_Concurrency;


import java.util.concurrent.TimeUnit;

/**
 *  任务类中惯用的处理中断方法. while (!Thread.interrupted()) { }
 */

class NeedsCleanup {
    private final int id;
    public NeedsCleanup(int ident) {
        id = ident;
        System.out.println("NeedsCleanup " + id);
    }

    public void cleanup() {
        System.out.println("cleaning up  " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

        /*-------------------- 中断点 1 -------------------------------------*/
                NeedsCleanup n1 = new NeedsCleanup(1);

                // Start try-finally immediately after definition of n1, to guarantee proper cleanup of n1:
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);

                    /* ----------------- 中断点 2 ---------------------------*/
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        // 耗时计算
                        System.out.println("    Calculating >>>");
                        for (int i = 0; i < 2500000; i++) {
                            d = d + (Math.PI + Math.E);
                        }
                        System.out.println("    Finished time-consuming operation <<<");
                    }
                    finally {
                        n2.cleanup();
                    }
                }
                finally {
                    n1.cleanup();
                }
            }   // END of while()
            System.out.println("    Exiting via while() test.");
        }
        catch (InterruptedException e) {
            System.out.println("    Exiting via InterruptedException!");
        }
    }   // End of run()
}

public class InterruptingIdiom {
    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.out.println("Usage : java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }

        Thread t = new Thread(new Blocked3());
        t.start();

        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
}
