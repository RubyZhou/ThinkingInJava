package Chapter20_Concurrency;

/**
 *  线程调度 : 单一一个 Main 线程
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
