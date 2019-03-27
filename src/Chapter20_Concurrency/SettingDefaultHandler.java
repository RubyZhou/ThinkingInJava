package Chapter20_Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  捕获异常 ：默认的异常处理器（处处相同的异常）
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
