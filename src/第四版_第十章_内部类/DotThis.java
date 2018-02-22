package 第四版_第十章_内部类;

/**
 * Function	: 使用 .this
 * Author	: 
 * Date		: [2018-02-22]
 * Desc		: 内部类中使用 .this 其实指的是其外围类
 * History	:
 */

public class DotThis {
	void f() { System.out.println("DotThis.f()"); }
	
	/*
	 * 一个内部类
	 */
	public class Inner {
		public DotThis outer() {
		// 【KEY】这边的 DotThis.this 只得是外部类
			return DotThis.this;
		}
	}
	
	// @调用内部类的方法
	public Inner inner() { return new Inner(); }
	
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.inner();
		dti.outer().f();
	}
	
}
