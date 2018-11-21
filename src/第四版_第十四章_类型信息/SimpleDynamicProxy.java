package 第四版_第十四章_类型信息;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  Desc : 一个简单的动态代理实现
 *
 *  关键内容 : 动态代理类实现 InvocationHandler 接口，再通过 Proxy.newProxyInstance() 调用动态代理类实现
 *
 *  Translation :
 *      DynamicProxyHandler - 动态代理操作工
 *      InvocationHandler   - 调用处理程序
 *      invoke              - 调用
 */

/**
 *  Function : InvocationHandler 接口的实现
 *
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object  proxied;

    /**
     * 构造参数接收一个被代理的 Object 对象
     * @param proxied
     */
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    /**
     * 代理类执行调用
     * @param proxy     - 调用对象
     * @param method    - 调用对象的方法
     * @param args      - 方法可能用到的参数列表
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("=========================== INFO =========================");
        System.out.println("proxy  = " + proxy.getClass());
        System.out.println("method = " + method);
        System.out.println("args   = " + args);
        System.out.println("==========================================================");

        // 循环输出 args 数组
        if (args != null) {
            for (Object arg : args)
                System.out.println(" " + arg);
        }

        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {

    public static void  consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {

        // STEP 1 ( for test ) : 首先进行直接调用实际类
        RealObject real = new RealObject();
        consumer(real);


        /**
         * STEP 2 : 初始化代理接口 (动态代理方式)
         *
         *      (1) 这里的代理接口依然和实际类保持同样的接口
         *
         *      (2) 创建动态代理 : 通过调用 static 方法 Proxy.newProxyInstance()
         *
         */
        System.out.println("interface.class = " + Interface.class);
        Interface proxy = (Interface) Proxy.newProxyInstance(   Interface.class.getClassLoader(),   // 类加载器
                                                                new Class[] { Interface.class },    // 该代理实现的接口列表
                                                                new DynamicProxyHandler(real)       // IvvocationHandler 接口的一个实现
                                                            );
        // 依然只需要向消费者传入执行接口 ( 代理类 )
        consumer(proxy);
    }

}
