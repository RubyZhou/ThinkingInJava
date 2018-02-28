package 第四版_第十章_内部类;

/**
 * Function	: AnonymousConstructor.java
 * Author	: zhouyf
 * Date		: 2018年2月28日
 * Version	: 1.0 
 * Desc		: 匿名内部类自身的构造方法, 因为匿名内部类没有类名，∴在类的定义的域中使用 {} 表示其构造函数
 * 				a. 构造方法调用顺序
 * 					1) 基类的构造器
 * 					2) 匿名内部类的构造器
 * 				b. 说明：基类构造器带参数  vs. 内部类构造器不带参数
 * 						调用的时候以基类的构造器为准
 * History	:
 */

abstract class Base {
	public Base(int i) {
		System.out.println("Base constructor. i = " + i);
	}
	public abstract void f();
}

public class AnonymousConstructor {

	/**
	 * @param args
	 */
	public static Base getBase(int i) {
		return new Base(i) {
			{ System.out.println("Inside instance initializer."); }
			public void f() {
				System.out.println("In anonymous f()");
			}
		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base base = getBase(47);
		base.f();
	}

}
