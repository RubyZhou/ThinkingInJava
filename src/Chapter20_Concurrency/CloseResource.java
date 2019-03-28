package Chapter20_Concurrency;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  通过关闭导致阻塞的底层资源, 让线程中断
 */
public class CloseResource {

    public static void main(String[] args) throws Exception {

        ExecutorService exec    = Executors.newCachedThreadPool();
        ServerSocket    server  = new ServerSocket(8080);
        InputStream     socketInput = new Socket("localhost", 8080).getInputStream();

        // 1. 拉起2种 I/O 任务
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);

        // 2. 关闭线程池方式. 两个阻塞线程未被中断
        System.out.println("    Shutting down all threads...");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);

        // 3. 关闭 io 资源方式中断. 关闭socket成功中断, 关闭System.in. 未被中断 ( 理论上应该被中断 )
        System.out.println("    Closing " + socketInput.getClass().getName());
        socketInput.close();    // Releases blocked thread
        TimeUnit.SECONDS.sleep(1);

        System.out.println("    Closing " + System.in.getClass().getName());
        System.in.close();
    }
}
