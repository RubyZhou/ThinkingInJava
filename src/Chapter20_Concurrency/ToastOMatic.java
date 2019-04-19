package Chapter20_Concurrency;

import java.util.Random;
import java.util.concurrent.*;

import static Fourth_util.Print.print;

/**
 *  吐司 BlockingQueue
 */

// 吐司类
class Toast {
    // 定义吐司的三个状态
    public enum Status { DRY, BUTTERED, JAMMED }
    private Status status = Status.DRY;

    private final int id;
    public Toast(int id) {
        this.id = id;
    }

    // 状态变更
    public void butter() { status = Status.BUTTERED; }
    public void jam()    { status = Status.JAMMED; }

    // get
    public Status   getStatus() { return status; }
    public int      getId()     { return id; }

    public String toString() {
        return "Toast " + id + " : " + status;
    }
}

// 吐司队列 : 参数为 Toast 类的 LinkedBlockingQueue
class ToastQueue extends LinkedBlockingQueue<Toast> { }


// 制作吐司
class Toaster implements Runnable {
    private ToastQueue  toastQueue;
    private int         count  = 0;
    private Random      random = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                Toast t = new Toast(count++);   // Make toast
                print(t);
                toastQueue.put(t);
            }
        }
        catch (InterruptedException e) {
            print("Toaster interrupted!");
        }
    }
}

// Apply butter to toast
class Butterer implements Runnable {
    private ToastQueue dryQueue, butteredQueue;
    public Butterer(ToastQueue dry, ToastQueue butter) {
        this.dryQueue      = dry;
        this.butteredQueue = butter;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast toast = dryQueue.take();  // 这个动作会一直等到从 dryQueue 中 take 到元素才会接着往下。
                toast.butter();
                print(toast);
                butteredQueue.put(toast);
            }
        }
        catch (InterruptedException e) {
            print("Butterer interrupted!");
        }
        print("Butterer off");
    }
}

// Apply jam to buttered toast
class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;    // FROM butteredQueue TO finishedQueue
    public Jammer(ToastQueue buttered, ToastQueue finished) {
        this.butteredQueue = buttered;
        this.finishedQueue = finished;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = butteredQueue.take();
                toast.jam();
                print(toast);
                finishedQueue.put(toast);
            }
        }
        catch (InterruptedException e) {
            print("Jammer interrupted!");
        }
        print("Jammer off");
    }
}


// Consume the Toast
// 最终的完成队列, 需要有一个兜底校验的动作。
class Eater implements Runnable {

    private ToastQueue finishedQueue;
    private int count = 0;
    public Eater(ToastQueue finished) {
        this.finishedQueue = finished;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = finishedQueue.take();

                if ( toast.getId() != count++ ||  toast.getStatus() != Toast.Status.JAMMED ) {
                    print(">>>>> Error : " + toast);
                    System.exit(-1);
                }
                else {
                    print("Chomp! " + toast);
                }
            }
        }
        catch (InterruptedException e) {
            print("Eater interrupted!");
        }
        print("Eater off");
    }
}


public class ToastOMatic {
    public static void main(String[] args) throws Exception{
        ToastQueue  dryQueue = new ToastQueue(),
                    butteredQueue = new ToastQueue(),
                    finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();

    }
}
