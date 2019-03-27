package Chapter20_Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  线程终结的引入案例 [游客进花园]
 */


/**
 *  跟踪游客的主计数值工具
 */
class Count {
    private int count = 0;
    private Random rand = new Random(47);

    // 写总计数 : 会有多个入口进行操作这个 count
    public synchronized int increment() {   // Remove the synchronized keyword to see counting fail:
        int temp = count;
        if (rand.nextBoolean()) {
            Thread.yield();     // 只为了增加耗时. count 属于共享变量
        }
        return (count = ++temp);
    }
    // 读取当前计数值
    public synchronized int value() {
        return count;
    }
}

// 模拟花园入口
class Entrance implements Runnable {

    private static List<Entrance>   entrances = new ArrayList<Entrance>();  // 类的实例维护队列
    private static Count            count = new Count();                    // 计数工具
    private static volatile boolean canceled = false;                       // 取消入园
    private int         number = 0;     // 每个入口的计数
    private final int   id;             // 线程 id. Doesn’t need synchronization to read

    // Keep this task in a list. Also prevents garbage collection of dead tasks:
    public Entrance(int id)     {
        this.id = id;
        entrances.add(this);        // 加入到类的实例的维护队列
    }

    public static void cancel() { canceled = true; }    /* Atomic operation on a volatile field */

    // 任务类 : 模拟游客进入
    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;   // 入口计数
            }
            System.out.println(this + " Total : " + count.increment()); // 总计数
            try     {
                TimeUnit.MILLISECONDS.sleep(100);   // 双重计数后休眠 100 秒
            }
            catch (InterruptedException e) {
                System.out.println("sleep interrupted!");
            }
        }
        System.out.println("stopping this!");
    }

    public String toString() {
        return "Entrance " + id + " : " + getValue();
    }
        // 读入口计数
    public synchronized int getValue() {
        return number;
    }
        // 读总计数
    public static int getTotalCount() {
        return count.value();
    }
        // 统计所有入口计数. 和总计数校验。
    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}

public class OrnamentalGarden {

    public static void main(String[] args) throws Exception {
        // 拉起线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new Entrance(i));

        // 停三秒, 关闭入口
        TimeUnit.SECONDS.sleep(5);
        Entrance.cancel();
        exec.shutdown();

        // 后续检查
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("Some tasks were not terminated!");

        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}
