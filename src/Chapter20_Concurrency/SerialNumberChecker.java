package Chapter20_Concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  测试 SerialNumberGenerator
 */

/**
 *  一个 Set 类 : 确保不会耗尽内存
 *      同时这个类是 synchronized 的, 保证了数组存的数和下标的索引值都是线程安全的
 */
class CircularSet {
    private int[]   array;
    private int     len;
    private int     index = 0;

    // 构造器初始化
    public CircularSet(int size) {
        array   = new int[size];
        len     = size;

        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    /**
     * 写操作 : 将值写入队尾, 下标 + 1
     * 说明 :
     *      这个 % 操作没有起到实质作用, 仅仅增加了耗时的操作
     *      (1) 读 index
     *      (2) ++
     *      (3) 进行 %
     *      (4) 写 index
     */
    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;

    }

    // 读操作 ： 遍历(读)数组, 判断是否包含需要增加的数
    public synchronized boolean contains(int val) {

        for (int i = 0; i < len; i++)  {
            if (array[index] == val) {
                return true;
            }
        }
        return false;
    }
}

public class SerialNumberChecker {

    private static final int    SIZE    = 10;   // 启动任务数量
    private static CircularSet  serials = new CircularSet(1000);    // 数组大小 : 1000
    private static ExecutorService exec = Executors.newCachedThreadPool();

    // （内部类）任务类
    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while (true) {
                // 通过 SerialNumberGenerator 获取序列号并非线程安全的, 存在对序列号的竞争
                int serial = SerialNumberGenerator.nextSerialNumber();

                if (serials.contains(serial)) {
                    System.out.println("Dulicate : " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception{

        for (int i = 0; i < SIZE; i++)
            exec.execute(new SerialChecker());

        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected!");
            System.exit(0);
        }
    }

}
