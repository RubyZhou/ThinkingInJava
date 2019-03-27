package Chapter20_Concurrency;


/**
 *  IntGenerator 接口的实现(2) : 带同步控制(synchronized)的实现
 */
public class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
