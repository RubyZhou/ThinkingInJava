package Chapter20_Concurrency;

/**
 *  在其他对象上（非 this）同步
 */

class DualSynch {
    private Object syncObject = new Object();
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }
    public void g() {
        // 若这里 synchronized 的是 this, 则对 DualSynch 类进行加锁。 同步时 f() 会将自身进行阻塞, 让 g() 先通过。
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
}
