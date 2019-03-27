package Chapter20_Concurrency;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  使用 原子性的 Integer 类. JAVA 5之后
 */
public class AtomicIntegerTest implements Runnable{

    private AtomicInteger i = new AtomicInteger(0);

    public int  getValue()      { return i.get();       }   // 读取   : 原子类
    public void evenIncrement() { i.addAndGet(2); }   // 读和写 : 原子类

    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {

        // 这个类的功能就是设置五秒延时, 然后中断.
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);   // Terminate after 5 seconds

        ExecutorService     exec = Executors.newCachedThreadPool();
        AtomicIntegerTest   ait  = new AtomicIntegerTest();

        exec.execute(ait);

        while (true) {
            int val = ait.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }

    }
}
