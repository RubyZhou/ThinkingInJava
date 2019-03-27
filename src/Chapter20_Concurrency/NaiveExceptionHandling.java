package Chapter20_Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  线程异常 : 即使放到try语句块中, 依然无法捕获到线程异常
 */
public class NaiveExceptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        }
        catch (RuntimeException e) {
            System.out.println("Exception has been handle!");
        }
    }
}
