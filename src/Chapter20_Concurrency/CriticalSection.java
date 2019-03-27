package Chapter20_Concurrency;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  (1) 将非线程安全的类引入多线程中.
 *  (2) 同步整个方法 [vs.] 同步部分块
 */

/**
 *  Pair 类 : 维护两个数 x 和 y, 要保证一致性, 但是维护的(读,写,检查)操作都没有标注成 synchronized.
 *      >> Not thread-safe。
 *      >> 但现在需要引入这个类, 同时又是加到多线程的环境里使用。
 */
class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pair() {
        this(0, 0);
    }

    /* 读操作 */
    public int getX()   { return x; }
    public int getY()   { return y; }

    /* 写操作 */
    public void incrementX()    { x++; }
    public void incrementY()    { y++; }

    public String toString() {
        return "x : " + x + ", y : " + y;
    }

    // 内部类, 定义异常
    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equals: " + Pair.this);
        }
    }

    // 检查, 如果监测出两数不相等, 报异常。 Arbitrary invariant -- both variables must be equal:
    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}

/**
 *  抽象类 : 保证"一对数儿"的线程安全 (Protect a Pair inside a thread-safe class )
 */
abstract class PairManager {

    AtomicInteger checkCounter = new AtomicInteger(0);  //
    protected   Pair p = new Pair();
    private     List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());   // 一个Pair的 List队列

    /**
     * Function : 备份
     *      Make a copy to keep the original safe.
     * @return  一个备份的 Pair
     */
    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    /**
     *  Function : 将传入的 Pair 元素向 List 中添加. 添加完毕后歇 50 毫秒
     *      Assume this is a time consuming operation. 假定这是一个非常重要的操作.
     * @param p
     */
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        }
        catch (InterruptedException ignore) {
        }
    }

    /**
     *  Function : 将 Pair 的 x,y 同时递增
     */
    public abstract void increment();
}


/**
 *  抽象的实现 1 ：使用同步方法
 *      Synchronize the entire method
 */
class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

/**
 *  抽象的实现 2 : 仅同步块
 *      Use a critical section
 */
class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        // 同步块, 临界区
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

/**
 *  测试任务 : Pair 控制器, 测试两种不同的 PairManager. 在任务中调用 increment(). 写操作
 */
class PairManipulator implements Runnable {
    private PairManager pm;
    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    public String toString() {
        return "Pair=[" + pm.getPair() + "] checkCounter=[" + pm.checkCounter.get() + "]";
    }
}

/**
 *  测试任务 : 不停的遍历整个队列, 同时检查每个存放的 Pair 对中的 x,y 是否相等
 */
class PairChecker implements Runnable {

    private PairManager pairManager;
    public  PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.checkCounter.incrementAndGet(); // 每次检查成功后, 进行递增, checkCounter 是AtomicInteger的, 无需额外控制
            pairManager.getPair().checkState();         // 先备份(读操作), 再检查
        }
    }
}

/**
 *  Test the two different approaches
 */
public class CriticalSection {
    /**
     * 测试方法
     * @param pman1
     * @param pman2
     */
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator
                pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(pman2);
        PairChecker
                pcheck1 = new PairChecker(pman1),
                pcheck2 = new PairChecker(pman2);

        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);

        // 让上述并发运行一段时间。
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        }
        catch (InterruptedException e) {
            System.out.println("Sleep interrupted!");
        }

        System.out.println("pm1={ " + pm1 + " }\npm2={ " + pm2 + " }");
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                pman1 = new PairManager1(),
                pman2 = new PairManager2();
        testApproaches(pman1, pman2);
    }
}
/* out
pm1={ Pair=[x : 83, y : 83] checkCounter=[4513476] }
pm2={ Pair=[x : 84, y : 84] checkCounter=[321036427] }
 */
