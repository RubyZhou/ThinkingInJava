package Chapter20_Concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  哲学家就餐 - 产生死锁的场景
 */
public class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws Exception{

        // 思考时间参数。 影响死锁触发概率，越接近0，越容易触发死锁
        int ponder = 5;
        if (args.length > 0) {
            ponder = Integer.parseInt(args[0]);
        }

        // 动态设置筷子数量参数!
        int size = 5;
        if (args.length > 1) {
            size = Integer.parseInt(args[1]);
        }

        ExecutorService exec = Executors.newCachedThreadPool();

        // 创建筷子
        Chopstick[] sticks = new Chopstick[size];

        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }

        // 哲学家就位, 哲学家线程放后台不停循环
        for (int i = 0; i < size; i++) {
                // 非常精髓!  (i+1) % size   >>  加了 % size， 最后一个 Philosopher 左边是最后一根筷子, 右边 size % size = 0 就成了第一根筷子了。
            exec.execute(new Philosopher(sticks[i], sticks[(i+1) % size], i, ponder));
        }

        // 主线程继续往下走, 需要对拉起的线程进行管理。
        //      考虑哲学家会死锁, 设置死锁超时强退 OR 手动退出
        if (args.length == 3 && args[2].equals("timeout")) {
            TimeUnit.SECONDS.sleep(5);
        }
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }

        exec.shutdownNow();
    }
}
