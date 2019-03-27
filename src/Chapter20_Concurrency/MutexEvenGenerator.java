package Chapter20_Concurrency;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  IntGenerator 接口的实现(3) : 显示加锁解决资源竞争
 */
public class MutexEvenGenerator extends IntGenerator {
    private int     currentEvenValue = 0;
    private Lock    lock = new ReentrantLock();

    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
