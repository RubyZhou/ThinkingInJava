package 第四版_第九章_接口;

import static util.Print.*;

/*
 * 服务接口： 工厂间约定生产统一规格的服务接口
 */
interface Service {
	void method1();
	void method2();
}

/*
 * 工厂接口：工厂必须实现创建服务接口实例的方法
 */
interface ServiceFactory {
	Service getService();
}

/*
 * 服务实现1 ：同一种规格的接口可以有不同的实现方法
 */
class Implementation1 implements Service {
	Implementation1() {}
	public void method1() { print("Implementation1's method1"); }
	public void method2() { print("Implementation1's method2"); }
}

/*
 * 服务工厂1 : 只能通过工厂才能产生服务，实际上是和具体服务绑定的
 */
class Implementation1Factory implements ServiceFactory {
	public Service getService() { return new Implementation1(); };
}

/*
 * 服务实现2
 */
class Implementation2 implements Service {
	Implementation2() {}
	public void method1() { print("Implementation2's method1"); }
	public void method2() { print("Implementation2's method2"); }
}

/*
 * 服务工厂2
 */
class Implementation2Factory implements ServiceFactory {
	public Service getService() { return new Implementation2(); };
}


public class Factories {
	/*
	 * 消费者方法
	 * (1) 通过输入的参数选择工厂
	 */
	public static void serviceConsumer(ServiceFactory fact) {
		//(2) 用一个接口（工厂间约定的规格）承接不同工厂的服务，通过所选择的工厂产生服务实例
		Service s = fact.getService();
		//(3) 服务生效
		s.method1();
		s.method2();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factories f = new Factories();
		f.serviceConsumer(new Implementation1Factory());
		f.serviceConsumer(new Implementation2Factory());
	}

}
