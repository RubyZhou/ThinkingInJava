package Chapter20_Concurrency;


import java.util.concurrent.TimeUnit;

/**
 *  IntGenerator 接口的实现(1) : 暴露出不同线程同时抢占一个资源导致异常结果。
 */
public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    // Function : 调用 next() 获取返回值, 判断这个返回值是否是偶数
    @Override
    public int next() {
        ++currentEvenValue;     // Danger point here!
        //(非原子操作, 这里会导致出错) 在这里可能有其他线程对 [资源 : currentEvenValue] 进行占用
        Thread.yield();
        ++currentEvenValue;

        return currentEvenValue;
    }

    public static void main(String[] args) throws Exception{
        EvenChecker.test(new EvenGenerator(), 100);
    }
}

