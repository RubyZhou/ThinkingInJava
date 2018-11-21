package 第四版_第十四章_类型信息;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Looking for particular methods in a dynamic proxy.
 *  对动态代理中特定需要的类进行控制
 */

/**
 *  动态代理类
 */
class MethodSelector implements InvocationHandler {

    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{

        // 在动态代理中做到仅对特殊类进行控制 : 这里仅对 interesting 方法进行控制
        if (method.getName().equals("interesting"))
            System.out.println("Proxy detected the interesting method");

        return method.invoke(proxied, args);
    }
}

/**
 *  所实现的接口
 */
interface SomeMethods {
    void boring1();
    void boring2();
    void boring3();
    void interesting(String arg);
}

/**
 *  实际进行实现的类
 */
class Implemention implements SomeMethods {
    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting " + arg);
    }
}




public class SelectingMethods {

    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                                SomeMethods.class.getClassLoader(),
                                new Class[] { SomeMethods.class },
                                new MethodSelector(new Implemention())
                            );
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonon");
        proxy.boring3();
    }

}
