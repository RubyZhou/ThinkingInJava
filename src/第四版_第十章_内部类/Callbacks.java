package 第四版_第十章_内部类;

/**
 * Function	: Callbacks.java
 * Author	: zhouyf
 * Date		: 2018年3月9日
 * Version	: 1.0 
 * Desc		: 闭包和回调
 * History	:
 */

import static util.Print.*;

/*
 * 【1】 自增接口
 */
interface Incrementable {
	void increment();
}

/*
 * 【1-1】 简易的接口实现 
 */
class Callee1 implements Incrementable {
	private int i = 0;
	public void increment() {
		i++;
		print(i);
	}
}

/* 
 * 【2】 我的Increment类作为接口，其中 increment 方法并非自增，而是做了一些其他的操作 
 */
class MyIncrement {
	public void increment()			{ print("Other operation"); }
	static void f(MyIncrement mi)	{ mi.increment(); }
}

/*
 * 【2-1】复杂的接口实现 Callee2 ，即继承了 MyIncrement ，又通过内部类实现了 Incrementabel() 
 * 	Callee2 继承了  MyIncrement
 */
class Callee2 extends MyIncrement {
	private int i = 0;
	
	/* 【2-2】 Callee2 并且重写了基类的方法, 如果你需要其他的 increment 方法，必须通过内部类的方式进行实现 */
	public void increment() {
		super.increment();
		i++;
		print(i);
	}
	/* 【2-3】这里使用内部类，去实现 Increment 接口中的 increment() 方法  */
	private class Closure implements Incrementable {	
		/*
		 * 说明：这里在内部类中，直接通过外部类名字调用外部类，用 .this 方法表示调用的时外部类中 increment();
		 * (1) 获取到外围类的引用：通过外围类名.this
		 * (2) 通过 this 可以区分内部类和外部类同名的方法	=>	从侧面说明了内部类是独立于他的外围类的
		 */
		public void increment() { 
			Callee2.this.increment();	/* 内部类是和外部隔断的，这里提供一个返回Callee2 的钩子，无论谁获得 Closure的引用都只能调用 increment */
		}
	}
	
	/*
	 * 【2-4】常规的外供一个接口的实现（内部类方式）
	 */
	Incrementable getCallbackReference() {
		return new Closure();
	}
}

/*
 * 【3】调用类，关键在于他的构造方法传进来的是谁
 */
class Caller {
	/*【3-1】 创建一个接口的变量  */
	private Incrementable callbackReference;
	
	/*【3-2】借用他人之手实现 Incrementable 接口，并且保存了他的引用 => 重点：这里保存之后就可以在任何时候回调 Callee 类了
	 * 通过构造方法把 incrementable 的实例（引用）传给 本地接口变量
	 */
	Caller(Incrementable cbh) { callbackReference = cbh; }
	
	/*【3-3】 本地接口变量间接的调用了 increment() 方法*/
	void go() { callbackReference.increment(); }
}

public class Callbacks {
	
	/* 【4】测试开始 */
	public static void main(String[] args) {
		
		Callee1 c1 = new Callee1();	// 简单的接口实现
		Callee2 c2 = new Callee2(); // 复杂的接口实现（即继承了 MyIncrement ，又通过内部类实现了 Incrementabel() ）
		
		/* 
		 * 【4-1】说明：这个 f() 是静态方法，可以随便直接调用 
		 * (1) 这里 MyIncrement.f() 触发 c2.increment()
		 * (2) c2.increment() 先通过 super 调用了父类的 increment => 显示 "Other operation"
		 * 						再自增内部变量 i 后显示 => 1
		 * 
		 *  这行代码输出信息 ：
		 *  -----------------------------
		 *  Other operation
		 *	1
		 *	-----------------------------
		 */
		MyIncrement.f(c2);
		
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());
		
		/* 【4-2】常规输出，内部变量 i =0 自增 1 */
		caller1.go();
		
		/* 【4-3】常规输出，内部变量 再增 1 */
		caller1.go();
		
		/* 【4-4】 因为之前已经调用过c2的  increment 了, 所以这里是2，剩下的常规输出，会先调用 super 的increment() */
		caller2.go();
		
		/* 【4-5】 同  4-4 */
		caller2.go();
		
		
	}

}











