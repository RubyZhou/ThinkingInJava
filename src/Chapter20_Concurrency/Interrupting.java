package Chapter20_Concurrency;


import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *  测试中断 3 种类型的阻塞。 cancel() 只能中断 sleep阻塞. 对于 I/O阻塞 和 同步锁阻塞 无效.
 */

// sleep 阻塞
class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Start sleeping...");
            TimeUnit.SECONDS.sleep(100);
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException!（SleepBlocked）");
        }
        System.out.println("Exiting SleepBlocked.run().");
    }
}

// I/O 阻塞
class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream is) {
        this.in = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read()");
            in.read();
        }
        catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            }
            else {
                throw new RuntimeException();
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

// 同步锁阻塞
class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        while (true) {      // Never releases lock
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call [synchronized]f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {

        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        /* 1. 启动线程池 */
        System.out.println("    start " + r.getClass().getName());
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);

        /* 2. 向线程发送 cancel() 请求 */
        System.out.println("    Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("    Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception{

        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());

        // main线程 兜底强制中断.
        System.out.println("\n[Main] Aborting with System.exit(0).");
        System.exit(0);     // ... since last 2 interrupts failed
    }
}
