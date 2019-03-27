package Chapter20_Concurrency;


/**
 *  创建有响应的用户界面, 前台等待用户输入, 同时后台执行计算。
 */
// 无响应的类
class   UnresponsiveUI {
    private volatile double d = 1;
    public  UnresponsiveUI() throws Exception {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
        System.in.read();   // Never gets here
    }
}

// 有响应的类 : 前台等待用户输入, 后台执行计算
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public  ResponsiveUI() {
        setDaemon(true);
        start();
    }

    // 这个任务在 main 等待用户的过程中不停的在后台进行累加计算
    public  void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
        //! new UnresponsiveUI();
        new ResponsiveUI();
        System.out.print("Please input a number : ");
        System.in.read();
        System.out.println(d);
    }
}

