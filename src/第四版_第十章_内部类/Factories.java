package 第四版_第十章_内部类;

/**
 * Function	: Factories.java
 * Author	: zhouyf
 * Date		: 2018年3月1日
 * Version	: 1.0 
 * Desc		:	匿名内部类在工厂方法中的应用(无需单独创建服务工厂类，将服务工厂通过内部类的方式直接在服务类中进行实现)
 * 
 * 			=>	【补充】 工厂方法基本流程
 * 				1) 定义服务接口：工厂间约定生产统一规格的服务接口
 * 				2) 定义工厂接口：工厂必须实现创建服务接口实例的方法
 * 				3) 定义服务实现1..n ：同一种规格的接口可以有不同的实现方法
 * 				4) 定义服务工厂1..n ：只能通过工厂才能产生服务，实际上是和具体服务绑定的
 * 				5) 定义消费者类：
 * 					(1)有一个消耗服务方法
 * 						a. 参数：通过输入的参数选择工厂
 * 						b. 构造方法 : private
 * 						c. 用一个服务接口变量	=<承接>=>	所选择工厂产生的服务实例
 * 						d. 服务生效：通过服务接口变量调用服务方法
 * 			=>	【补充】 对工厂方法的思考 
 * 					 解决消费者可有不同的选择，不同的工厂有不同的产品（多对多） 
 * History	: 
 */
import static util.Print.*;

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
