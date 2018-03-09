package 第四版_第十章_内部类;

/**
 * Function	: MultiInterfaces.java
 * Author	: zhouyf
 * Date		: 2018年3月9日
 * Version	: 1.0 
 * Desc		: 多重继承：接口方式实现  vs. 内部类方式
 * History	:
 */

/*
 * (1) 定义两个接口A,B
 */
interface A {}
interface B {}

/*
 * (2) 类 X 通过 implements 继承多个接口
 */
class X implements A,B {}

/*
 * (3) 类 Y 通过内部类的方式继承多个接口
 */
class Y implements A {
	/* makeB方法返回一个 B 类型接口的实现  */
	B makeB() {
		/* 匿名内部类，因为 B 是个接口，在 new 的时候完成实现。 */
		return new B() {};
	}
}

public class MultiInterfaces {
	
	/*
	 * (4) 测试类两个方法分别需要AB两个接口的实例，可以用 X(产品)，也可以用 Y(产品) 
	 */
	static void takesA(A a) {}
	static void tabkeB(B b) {}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * (5) 新建两个类的实例
		 */
		X x = new X();
		Y y = new Y();
		
		/* (6.1) => x同时实现了A和B */
		takesA(x);
		tabkeB(x);
		
		/* (6.2) => y以匿名内部类的方式提供 B 功能 */
		takesA(y);
		tabkeB(y.makeB());
		
	}

}
