package Chapter20_Concurrency;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  任务阻塞死锁和中断方法. lock.lockInterruptibly()
 */

class BlockedMutex {
    private Lock lock = new ReentrantLock();

    // 1. 构造器里直接加锁, 创建实例就锁上整个类
    public BlockedMutex() {
        lock.lock();
    }

    // 2. f() 中也对 BlockedMutex 类加锁.
    public void f() {
        try {
            System.out.println("This is f() >>>> ");
            // Special call, 如果这里也使用 lock.lock(), 就死锁了. 无法中断了.
            lock.lockInterruptibly();
            System.out.println("lock acquired in f()");
        }
        catch (Exception e) {
            System.out.println("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable {
    BlockedMutex blockedMutex = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("    Waiting for f() in BlockedMutex");
        blockedMutex.f();
        System.out.println("    Broken out of blocked call.");
    }
}

public class Interrupting2 {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("    Issuing t.interrupt()");
        t.interrupt();
    }
}
