package Chapter20_Concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  IntGenerator接口的通用测试类框架
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator; // 亮点 : 使用组合代替继承。要保证使用的类是标准化的(使用接口而非实际类)，良好的隔离性。
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {    // 构造器
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() { // 任务方法 : 测试是否是偶数
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    // IntGenerator的通用测试类, 可以传入任意实现了 IntGenerator接口的实际类, 同时带上 id 标识。
    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();

        // 拉起十个线程, 进行测试
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    // 亮点 : 重载, 提供了多样的输入接口, 其他参数相当于直接由本程序设置默认值
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
