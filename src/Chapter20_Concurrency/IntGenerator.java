package Chapter20_Concurrency;


/**
 *  IntGenerator 接口 : 包含了 消费者任务的 必要方法 ：next() 和 撤销 undo() 等
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public  abstract int next();    // 调用 next() 获取返回值, 判断这个返回值是否是偶数
    public  void    cancel()        { canceled = true; }
    public  boolean isCanceled()    { return canceled; }
}
