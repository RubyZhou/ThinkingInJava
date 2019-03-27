package Chapter20_Concurrency;

import java.util.concurrent.TimeUnit;


/**
 *  后台线程 demo
 */
public class SimpleDaemons implements Runnable{
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " : " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted!");
        }
    }

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemon started!");
        // 如果不设置, 则 main() 函数直接结束, 不会管后台进程的打印信息
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
