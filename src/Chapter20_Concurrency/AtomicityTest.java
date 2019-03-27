package Chapter20_Concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  原子性测试 : 测试失败, getValue() 的读操作, 读到了 evenIncrement() 写入的中间状态.
 *      原因 : 写操作设置了 synchronized, 但是读操作没有设成 synchronized
 */
public class AtomicityTest implements Runnable {

    private int i = 0;

    // 表面看 getValue() 只有一个 return 操作, 很像原子操作. 但是没有增加 synchronized 读到了 evenIncrement() 写入的中间状态
    public int getValue()   {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest   at   = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
