/**
 * 
 */
package 第四版_第十二章_通过异常处理错误;

/**
 * Function	: FullConstructors.java
 * Author	: zhouyf
 * Date		: 2018年4月26日 
 * Version	: 1.0 
 * Desc		: 打印异常详细信息 【e.printStackTrace()】
 * History	:
 */

class MyException extends Exception {
	public MyException()			{ }
	public MyException(String msg)	{ super(msg); }
}

public class FullConstructors {
	
	public static void f() throws MyException {
		System.out.println("Throwing MyException from f()");
		throw new MyException();
	}
	
	public static void g() throws MyException {
		System.out.println("Throwing MyException from g()");
		throw new MyException("Originated in g()");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			f();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}
		
		try {
			g();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}
		
	}

}
