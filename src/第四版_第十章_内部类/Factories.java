package 第四版_第十章_内部类;

import static 第四版_源码_util.Print.*;

/*
 * 两个接口不变
 */
interface Service {
	void method1();
	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implementation1 implements Service {
	private Implementation1() {}
	public void method1() { print("Implementation1's method1."); };
	public void method2() { print("Implementation1's method2."); };
	
	/*
	 * 匿名内部类 : 
	 * 		1. 创建一个类的实例，相当于 public A a = new A();
	 * 		2. 被创建为 Service 实现中的一个静态 static 域
	 * 
	 * 问题：这里为什么要创建成 static ? (注：如果没有会报如下错误信息)
	 * -------------------------------------------------------------------------------------------
	 * 	Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	 * 		Cannot make a static reference to the non-static field Implementation1.factory
	 * 		at 第四版_第十章_内部类.Factories.main(Factories.java:70)
	 * -------------------------------------------------------------------------------------------
	 */
	public static ServiceFactory factory = 
			new ServiceFactory() {
				public Service getService() { return new Implementation1(); }
			};
}

class Implementation2 implements Service {
	/* 注意：这里的构造器是 private 的，因此客户端通过服务类创建工厂的时候，并没有创建出服务类的实例  => 此处有点疑惑 ？ */
	private Implementation2() {}
	public void method1() { print("Implementation2's method1."); };
	public void method2() { print("Implementation2's method2."); };
	
	/*
	 * 匿名内部类 : 创建一个类的实例，相当于 public A a = new A();
	 */
	public static ServiceFactory factory = 
			new ServiceFactory() {
				public Service getService() { return new Implementation2(); }
			};
}

public class Factories {

	public static void serviceConsumer(ServiceFactory fact) {
		Service s = fact.getService();
		s.method1();
		s.method2();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 通过 类.匿名内部类 返回一个工厂接口实例
		serviceConsumer(Implementation1.factory);
		serviceConsumer(Implementation2.factory);
	}

}
