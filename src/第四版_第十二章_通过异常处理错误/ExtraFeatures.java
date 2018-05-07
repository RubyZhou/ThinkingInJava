/**
 * 
 */
package 第四版_第十二章_通过异常处理错误;

/**
 * Function	: ExtraFeatures.java
 * Author	: zhouyf
 * Date		: 2018年5月7日 
 * Version	: 1.0 
 * Desc		: 进一步定义异常（增加构造器和成员）
 * History	:
 */

import static util.Print.*;

/*
 * 自定义异常类
 */
class MyException2 extends Exception {
	
	private int x;
	/*------------------ 构造器 ------------------------*/
	public MyException2()					{}
	public MyException2(String msg)			{ super(msg); }
	public MyException2(String msg, int x)	{	/* 带有点错误码的味道 */
		super(msg); 
		this.x = x;
	}
	
	public int val()			{ return x; }
	public String getMessage()	{ return "Detail Message : " + x + " " + super.getMessage(); }
		
}

public class ExtraFeatures {
	
	public static void f() throws MyException2 {
		print("Throwing MyException2 from f()");
		throw new MyException2();
	}
	
	public static void g() throws MyException2 {
		print("Throwing MyException2 from g()");
		throw new MyException2("Originated in g()");
	}
	
	public static void h() throws MyException2 {
		print("Throwing MyException2 from h()");
		throw new MyException2("Originated in g()", 47);
	}
	
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("-----------------------------------------------------------------------------");
		/* 测试I */
		try {
			f();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		System.out.println("-----------------------------------------------------------------------------");
		/* 测试II */
		try {
			g();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		System.out.println("-----------------------------------------------------------------------------");
		/* 测试III */
		try {
			h();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
			System.out.println("e.val() = " + e.val());
		}
	}

}
