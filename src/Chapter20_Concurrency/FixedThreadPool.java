package Chapter20_Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  FixedThreadPool : 固定数量线程池
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
