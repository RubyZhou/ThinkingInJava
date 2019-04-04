package Chapter20_Concurrency;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  notify() vs. notifyAll()
 */

class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        }
        catch (InterruptedException e) {
            // OK to exit this way
        }
    }
    // 这里将 notify() 包装了一下, 设成 synchronized.
    // 目的 : 只唤醒在等待这个 Blocker 类锁的任务
    synchronized void prod()    { notify(); }
    synchronized void prodAll() { notifyAll();}
}

// 任务类1 : 创建 Blocker 并吊起 waitingCall() 方法
class Task implements Runnable {
    static Blocker blocker = new Blocker();
    @Override
    public void run() { blocker.waitingCall(); }
}


// 任务类2 : 和 任务 1 一样。 A separate Blocker object
class Task2 implements Runnable {
    static Blocker blocker = new Blocker();
    @Override
    public void run() { blocker.waitingCall(); }

}

// 线程主调测试框架
public class NotifyVsNotifyAll {

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        // 这里5个任务共享同一个 Blocker 类锁资源
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }
        exec.execute(new Task2());

        Timer timer = new Timer();
        /*-----------------------------------------------------*/
        timer.scheduleAtFixedRate( new TimerTask() {
                    boolean prod = true;
                    @Override
                    public void run() { // 交替 notify() 和 notifyAll()
                        if (prod) {
                            System.out.println("\n notify()");
                            Task.blocker.prod();
                            prod = false;
                        } else {
                            System.out.println("\n notifyAll()");
                            Task.blocker.prodAll();
                            prod = true;
                        }
                    }
                }, 400, 400);
        /*-----------------------------------------------------*/
        TimeUnit.SECONDS.sleep(5);

        // 运行 5 秒后, 中断定频任务
        timer.cancel();
        System.out.println("\n Timer canceled");
        TimeUnit.MILLISECONDS.sleep(500);

        // 注 : 这里 Task2 虽然是 notifyAll() 但是 Task1 中的 5 个任务均未被唤醒.
        System.out.println("Task2.blocker.prodAll() ");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println("\n Shutting down");
        exec.shutdownNow();
    }
}






