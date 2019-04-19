package Chapter20_Concurrency;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static Fourth_util.Print.print;
import static Fourth_util.Print.printnb;

/**
 *  任务间使用管道进行输入/输出
 *      >> 是"生产者 - 消费者" 问题变体
 *      >> 实践封装的优秀解决方案
 */

// 生产者< PipedWriter >
class Sender implements Runnable {
    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();
    // get
    public PipedWriter getPipedWriter() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    print("Sender : " + c);
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        }
        catch (IOException e) {
            print(e + "Sender wirte Exception.");
        }
        catch (InterruptedException e) {
            print(e + "Sender sleep interrupted.");
        }
    }
}

// 消费者< PipedReader >
class Receiver implements Runnable {
    private PipedReader in;
    public Receiver(Sender sender) throws Exception {
        this.in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true) {
                /* 阻塞区, 等待管道传来数据(接收方是每隔一定时间周期统一接收一次) */
                print("         Reader : " + (char) in.read());
            }
        }
        catch (IOException e) {
            print(e + "Reveiver read exception.");
        }
    }
}

public class PipedIO {
    public static void main(String[] args) throws Exception{
        Sender   sender   = new Sender();
        Receiver receiver = new Receiver(sender);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
