package Chapter20_Concurrency;


import java.util.concurrent.TimeUnit;

/**
 *  被互斥的阻塞. 对同一个类加多把锁
 */
public class MultiLock {
    public synchronized void f1(int count) throws InterruptedException {
        if (count-- > 0) {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("f1() calling f2() with count " + count);
            f2(count);
            System.out.println("f1() <<<<<");
        }
    }

    public synchronized void f2(int count) throws InterruptedException {
        if (count-- > 0) {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("f2 calling f1() with count " + count);
            f1(count);
            System.out.println("f2() <<<<<");
        }
    }

    public synchronized void f3()  {
        System.out.println(">>>>>>>>>>> f3()");
    }

    public static void main(String[] args) throws InterruptedException {
        final MultiLock multiLock = new MultiLock();
        new Thread() {
            @Override
            public void run() {
                try {
                    multiLock.f1(10);
                }
                catch (InterruptedException e) {
                    System.out.println("Interrupte!");
                }
            }
        }.start();

        TimeUnit.MILLISECONDS.sleep(200);
        new Thread() {
            @Override
            public void run() {
                multiLock.f3();
            }
        }.start();
    }
}
