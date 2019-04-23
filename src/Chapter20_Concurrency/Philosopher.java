package Chapter20_Concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static Fourth_util.Print.print;

/**
 *  哲学家就餐 - 哲学家
 */
public class Philosopher implements Runnable{
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;     // 思考系数, 设置哲学家的思考时间
    private Random rand = new Random(47);

    // 以休眠的方式模拟哲学家思考
    private void pause() throws InterruptedException {
        if (ponderFactor == 0)
            return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor*500));
    }

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left  = left;
        this.right = right;
        this.id    = id;
        this.ponderFactor = ponderFactor;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //
                print(this + " " + "thinking");
                pause();

                // Philosopher becomes hungry
                print(this + " " + "grabbing right");
                right.take();
                print(this + " " + "grabbing left");
                left.take();

                // 吃完了
                right.drop();
                left.drop();
            }
        }
        catch (InterruptedException e) {
            print(this + "exiting via interrupt");
        }
    }

    public String toString() {
        return "Philosopher[" + id + "]";
    }
}
