package Chapter20_Concurrency;

import java.util.concurrent.TimeUnit;

/**
 *  将线程附加至已有线程上 ( join )
 */

class Sleeper extends Thread {  // 被 join() 的线程
    private int duration;
    public Sleeper(String name, int sleepTime) {
        //super(name);
        duration = sleepTime;
        start();
    }
    @Override
    public void run() {
        try {
            sleep(duration);
        }
        catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. " + "isInterrupted() : " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {   // join() 到 sleeper 线程上的 Thread
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }
        System.out.println(getName() + " completed!");
    }
}

public class Joining {
    public static void main(String[] args) throws Exception {
        Sleeper sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner dopey   = new Joiner("Dopey", sleepy),
               doc     = new Joiner("Doc",   grumpy);
        grumpy.interrupt();
    }
}















