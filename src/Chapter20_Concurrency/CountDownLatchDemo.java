package Chapter20_Concurrency;


import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static Fourth_util.Print.print;

/**
 *  新库中的构件 - CountDownLatch
 */

// Performs some portion of a task:
class TaskPortion implements Runnable {
    private static  int counter = 0;
    private final   int id = counter++;
    private static  Random rand = new Random(47);
    private final   CountDownLatch latch;
    public  TaskPortion(CountDownLatch latch)   { this.latch = latch; }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        }
        catch (InterruptedException ex) {
            // Acceptable way to exit
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        print(this + "Completed.");
    }

    public String toString() {
        return String.format("[%1$-3d] ", id);
    }
    // %1$-3d
    // 1) %d     = 整数
    // 2) %-3d   = 左对齐3位 (默认右对齐)
    // 3) %1$-3d = 第一个变量左对齐3位 ("x$ 表示第 x 个变量". 作用 : 让同一个变量可以用多次)
}

// Waits on the CountDownLatch:
class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;
    public  WaitingTask(CountDownLatch latch) { this.latch = latch; }

    @Override
    public void run() {
        try {
            latch.await();
            print("Latch barrier passed for [" + this + "]");
        }
        catch (InterruptedException ex) {
            print(this + " interrupted.");
        }
    }

    public String toString() {
        return String.format("WaitingTask [%1$-3d]", id);
    }
}

public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        /* All must share a single CountDownLatch object: */
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            exec.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new TaskPortion(latch));
        }
        print("Launched all tasks.");
        exec.shutdown();

    }
}