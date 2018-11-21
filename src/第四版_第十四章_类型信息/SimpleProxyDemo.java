package 第四版_第十四章_类型信息;


/**
 *  一个简单的代理模式实现
 */

/**
 *  实际类 和 代理类 共同实现的接口
 */
interface Interface {
    void    doSomething();
    void    somethingElse(String arg);
}

/**
 * 实际类 : 真实完成接口实现
 */
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

/**
 *  代理类 ： 将实际类以接口的方式传入, 然后在自己实现接口的地方通过调用实际类的方式完成相应功能( 同时追加一部分额外的功能 )
 */
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
        System.out.println("-------------- 直接调用 -------------------");
        consumer(new RealObject());

        System.out.println("-------------- 通过代理调用 -------------------");
        consumer(new SimpleProxy(new RealObject()));
    }

}
