package Chapter20_Concurrency;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 *  生产者和消费者队列。阻塞队列。
 */

// 任务队列运行线程 : 不停地从 BlockingQueue 队列中 take() 任务. 调用任务自身的 run() 方法
class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff>  rockets;
    public  LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    public  void add(LiftOff lo) {
        try {
            rockets.put(lo);
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        }
        catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}

public class TestBlockingQueues {
    // 获取系统输入
    static void getkey() {
        try {
            // Compensate for Windows/Linux difference in the
            // length of the result produced by the Enter key:
            new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
        }
        catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
    // 封装输入, 带提示信息
    static void getKey(String message) {
        System.out.println(message);
        getkey();
    }

    /** 主测试流程
     *
     * @param msg
     * @param queue
     *
     * 1) 传入具体的队列实现
     * 2) 拉起任务队列运行线程, 添加 5 个任务进队列
     */
    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.print(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);

        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }

        getKey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        System.out.print("Finished " + msg + "test");
    }

    public static void main(String[] args) {
        test("[LinkedBlockingQueue] ", new LinkedBlockingQueue<LiftOff>());            // Unlimited size
        test("[ArrayBlockingQueue ] ", new ArrayBlockingQueue<LiftOff>(3));   // Fixed size
        test("[SynchronousQueue   ] ", new SynchronousQueue<LiftOff>());               // Size of 1
    }
}
