package Chapter20_Concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  哲学家就餐 - 解决死锁的场景
 */
public class FixedDiningPhilosophers {

    public static void main(String[] args) throws Exception{

        // 设置思考系数
        int ponder = 5;
        if (args.length > 0) {
            ponder = Integer.parseInt(args[0]);
        }

        // 筷子数
        int size = 5;
        if (args.length > 1) {
            size = Integer.parseInt(args[1]);
        }

        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            if (i < (size - 1)) {
                exec.execute(new Philosopher(chopsticks[i], chopsticks[i + 1], i, ponder));
            }
            else {  // 最后一个 Philosopher 换手
                exec.execute(new Philosopher(chopsticks[0], chopsticks[i], i, ponder));
            }
        }

        // 线程后续清理
        if (args.length == 3 && args[2].equals("timeout")) {
            TimeUnit.SECONDS.sleep(5);
        }
        else {
            System.out.println("Press 'Enter' to quit : ");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
