package Chapter20_Concurrency;


import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *  在 Executor 上使用基本的 interrupt() 方法
 */

// sleep 阻塞
class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        }
        catch (InterruptedException e) {
            System.out.println("SleepBlocked : InterruptedException!");
        }
        System.out.println("SleepBlocked : Exiting SleepBlocked.run().");
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
            System.out.println("Waiting for read() : ");
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
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    // 用 submit() 拉起任务后, 等100毫秒, 再中断该任务.
    static void test(Runnable r) throws InterruptedException {

        Future<?> f = exec.submit(r);
        System.out.println("Interrupting.test() : start " + r.getClass().getName());
        TimeUnit.MILLISECONDS.sleep(100);

        System.out.println("Interrupting.test() : Interrupting " + r.getClass().getName());
        // 发起中断.
        /*---------------------------------------------------*/
        f.cancel(true);
        /*---------------------------------------------------*/
        System.out.println("Interrupting.test() : Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception{
        /*---------------------------------------------------*/
        test(new SleepBlocked());
        /*---------------------------------------------------*/
        System.out.println("Main : Aborting with System.exit(0)");
        System.exit(0); // ... since last 2 interrupts failed
    }
}
