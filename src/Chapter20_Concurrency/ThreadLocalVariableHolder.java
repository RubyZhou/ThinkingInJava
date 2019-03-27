package Chapter20_Concurrency;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  线程本地变量. 不共享, 防止任务在共享资源上产生冲突
 */

// 任务类 : 驱动 ThreadLocalVariableHolder 中的 ThreadLocal 进行无限递增。
class Accessor implements Runnable {
    private final int id;
    public Accessor(int idn) {
        this.id = idn;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    @Override
    public String toString() {
        return "#" + id + " : " + ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {
    // 创建一个线程的本地变量 : value  （注 : 每个线程的本地变量不共用）
    private static ThreadLocal<Integer> value =
            new ThreadLocal<Integer>() {
        private Random rand = new Random(47);
        protected synchronized Integer initialValue() { return rand.nextInt(1000); }    // 初始化一个随机值。
            };


    // ThreadLocal 因为是本地存储, 保证不会出现资源竞争, get() / set() 无需 synchronized
    public static void  increment() { value.set(value.get() + 1); }
    public static int   get()       { return value.get(); }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        exec.shutdown();
    }
}
