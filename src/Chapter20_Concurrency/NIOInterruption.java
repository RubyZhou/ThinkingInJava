package Chapter20_Concurrency;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static Fourth_util.Print.print;

/**
 *  使用 NIO 进行线程中断
 */

class NIOBlocked implements Runnable {

    private final SocketChannel sc;
    public NIOBlocked(SocketChannel sc) { this.sc = sc; }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        }
        catch (ClosedByInterruptException e) {
            System.out.println("ClosedByInterruptException!");
        }
        catch (AsynchronousCloseException e) {
            // 当一个通道关闭时，休眠在该通道上的所有线程都将被唤醒并收到一个AsynchronousCloseException异常
            System.out.println("AsynchronousCloseException!");
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
        System.out.println("Exiting NIOBlock.run() " + this);
    }
}

public class NIOInterruption {

    public static void main(String[] args) throws Exception {

        ExecutorService     exec = Executors.newCachedThreadPool();
        ServerSocket        server = new ServerSocket(8080);
        InetSocketAddress isa =
                new InetSocketAddress("localhost", 8080);
        SocketChannel       sc1 = SocketChannel.open(isa);
        SocketChannel       sc2 = SocketChannel.open(isa);

        // 1. 拉起启动线程
        Future<?> f = exec.submit(new NIOBlocked(sc1));
        exec.execute(new NIOBlocked(sc2));

        // 2. 立马中断. 这一步是无法中断IO阻塞线程的
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);

        // 3. 通过设置 cancel() 标志, 中断 submit() 拉起的IO阻塞线程.
        f.cancel(true);     // Produce an interrupt via cancel
        TimeUnit.SECONDS.sleep(1);

        // 4. 关闭通道资源. 中断 execute() 拉起的IO阻塞线程.
        sc2.close();    // Release the block by closing the channel
    }
}
