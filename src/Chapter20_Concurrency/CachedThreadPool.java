package Chapter20_Concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  CachedThreadPool : 为每个任务创建线程
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
