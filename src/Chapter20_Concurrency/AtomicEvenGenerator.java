package Chapter20_Concurrency;


import java.util.concurrent.atomic.AtomicInteger;

/**
 *  使用SE5之后的原子变量 : AtomicInteger 重构 EvenGenerator
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
