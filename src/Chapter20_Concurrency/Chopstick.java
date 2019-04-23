package Chapter20_Concurrency;

/**
 *  哲学家就餐 - 筷子
 */
public class Chopstick {
    private boolean taken = false;

    // 拿筷子
    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
    }

    // 放筷子
    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
