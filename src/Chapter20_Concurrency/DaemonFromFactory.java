package Chapter20_Concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  定制线程属性 :
 *      STEP 2 ：测试定制线程信息, 本案例同时也是一个任务类
 */
public class DaemonFromFactory implements Runnable{

    // 这个任务主要就是执行一个死循环打印线程信息
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }
    }

    public static void main(String[] args) throws Exception{
        // 创建定制线程属性. 传入任务
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());

        // 启动线程, 下列线程都是后台线程了
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started!");
        TimeUnit.MILLISECONDS.sleep(500);   // Run for a while
    }
}
