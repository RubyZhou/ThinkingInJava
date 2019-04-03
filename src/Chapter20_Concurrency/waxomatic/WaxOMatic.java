package Chapter20_Concurrency.waxomatic;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  线程之间协作
 *      引入案例 : 给车抛光和打蜡
 */


class Car {
    // 状态参数 : false - 未打蜡
    private boolean waxOn = false;

    // 打蜡完成. 修改状态
    public synchronized void waxed() {
        waxOn = true;       // Ready to buff
        notifyAll();
    }

    // 抛光完成. 修改状态
    public synchronized void buffed() {
        waxOn = false;      // Ready for another coat of wax
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true) {
            wait();
        }
    }
}

/**
 * 任务类 : 打蜡. (设定了任务执行流程)
 */
class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }
        catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

/**
 * 任务类 : 抛光. (设定了任务执行流程)
 */
class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }
        catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}

/**
 *  测试类。控制任务并发 & 拉起的初始化 & 中断
 */
public class WaxOMatic {
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}
