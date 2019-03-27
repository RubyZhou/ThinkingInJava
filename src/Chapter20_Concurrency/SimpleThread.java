package Chapter20_Concurrency;


/**
 *  编码的变体 : 直接继承 Thread 创建线程, 不用实现任务类(Runnable)
 */
public class SimpleThread extends Thread {
    // 1. 直接继承 Thread
    private int         countDown   = 5;
    private static int  threadCount = 0;
    // 2. 在构造器中 启动线程 + 命名 + etc
    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    public String toString() {
        return "#" + getName() + "(" + countDown + ")";
    }

    // 3. 编写 run() 方法
    @Override
    public void run() {
        while(true) {
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }

    // 4. 在测试类中直接 new 即可
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
