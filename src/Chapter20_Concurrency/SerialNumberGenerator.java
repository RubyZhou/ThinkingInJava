package Chapter20_Concurrency;


/**
 *  序列号生成器
 *
 *      >> 原子性验证 : 就一个 ++ 动作, 看是不是原子操作。这个操作即读又写。
 *
 *      结论 ： 不是原子操作, 非线程安全. 发生了多个任务获取了同一个序列号。
 *      解决方法 : 添加 synchronized
 *          >> synchronized 保证了 serialNumber 在所有任务中的备份都是同步的. (就是一个共享资源)
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public  static synchronized int nextSerialNumber() {
        return serialNumber++;
    }
}
