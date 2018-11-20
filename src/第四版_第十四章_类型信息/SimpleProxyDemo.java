package 第四版_第十四章_类型信息;


/**
 *  一个简单的代理模式实现
 */
interface Interface {
    void    doSomething();
    void    somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somthingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface   proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------");
        consumer(new RealObject());                     // 直接调用
        System.out.println("---------------------------------");
        consumer(new SimpleProxy(new RealObject()));    // 通过代理调用
    }

}
