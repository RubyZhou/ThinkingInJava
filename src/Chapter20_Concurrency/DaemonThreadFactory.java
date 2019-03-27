package Chapter20_Concurrency;


import java.util.concurrent.ThreadFactory;

/**
 *  定制线程属性 :
 *      STEP 1 : 编写 ThreadFactory 来定制Executor创建的线程属性 ( 后台, 优先级, 名称 ) : 本定制就是将所有线程设成后台线程
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);  // 差异处
        return t;
    }
}
