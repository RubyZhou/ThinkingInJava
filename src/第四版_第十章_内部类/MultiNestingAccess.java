package 第四版_第十章_内部类;

/**
 * Function	: MultiNestingAccess.java
 * Author	: zhouyf
 * Date		: 2018年3月6日
 * Version	: 1.0 
 * Desc		: 无论嵌套几层，内部类都可以访问外部类所有成员
 * History	:
 */

class MMA {
	/* 第 I 层方法 */
	private void f() {}
	class A {
		/* 第 II 层方法 */
		private void g() {}
		public class B {
			/* 第 III 层方法可以调用第 I ,II 层方法  */
			void h() {
				g();
				f();
			}
		}
	}
}

public class MultiNestingAccess {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MMA mma = new MMA();
		MMA.A mmaa = mma.new A();
		MMA.A.B mmaab = mmaa.new B();
		mmaab.h();
	}
}
