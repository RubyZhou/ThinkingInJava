package Chapter20_Concurrency;


import java.util.concurrent.TimeUnit;

import static Fourth_util.Print.printnb;

/**
 *  验证
 *      1) 后台线程具有继承性, 通过后台线程创建的线程都是后台线程
 *      2) Thread.isDaemon() : 判断是否是后台线程
 */
class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        //  启动十个线程, 启动后直接挂起
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn [" + i + "] started, ");
        }
        // 打印是否是后台线程
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
        }
        // 挂起本后台线程
        while (true)
            Thread.yield();
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}

public class Daemons {

    public static void main(String[] args) throws Exception {

        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();

        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}