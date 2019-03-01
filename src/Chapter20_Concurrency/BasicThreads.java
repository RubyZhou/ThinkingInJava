package Chapter20_Concurrency;

/**
 *  基本线程使用
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread  t = new Thread(new LiftOff());
        t.start();  // 创建的线程开始单独执行任务, Main线程则继续向下执行
        System.out.println("Waiting for LiftOff.");
    }
}
