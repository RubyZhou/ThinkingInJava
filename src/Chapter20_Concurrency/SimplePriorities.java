package Chapter20_Concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  线程的优先级
 */
public class SimplePriorities implements Runnable{

    private int             countDown = 5;
    private volatile double d;
    private int             priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + " : " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 1000000; i++) {
                d += (Math.PI + Math.E) / (double)i;    // 无用操作, 只是让CPU做浮点运算
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (countDown-- == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        // 虽然下面的代码在后面, 但是优先级比较高, 所以先执行
        exec.execute(new SimplePriorities(Thread.NORM_PRIORITY));
        exec.shutdown();
    }
}
