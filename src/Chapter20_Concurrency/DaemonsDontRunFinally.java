package Chapter20_Concurrency;


import java.util.concurrent.TimeUnit;

/**
 *  后台线程的注意事项 ：main()函数一旦结束退出, 所有后台进程将会强制杀掉，无论是否执行完毕。
 */

class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(2);
        }
        catch(InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        }
        finally {
            // main() 结束后, 后台进程被强制杀掉. 下列部分内容不会打印
            System.out.println("This should always run?");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception{
        Thread  t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(1);
    }
}
