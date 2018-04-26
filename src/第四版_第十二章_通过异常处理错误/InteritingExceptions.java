/**
 * 
 */
package 第四版_第十二章_通过异常处理错误;

/**
 * Function	: InteritingExceptions.java
 * Author	: zhouyf
 * Date		: 2018年4月26日 
 * Version	: 1.0 
 * Desc		: 自定义异常 (继承自某个系统异常)
 * History	:
 */

class SimpleException extends Exception {}

public class InteritingExceptions {
	
	public void f() throws SimpleException {
		System.out.println("Throw SimpleException from f()");
		throw new SimpleException();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InteritingExceptions sed = new InteritingExceptions();
		
		try { 
			sed.f(); 
		} catch (SimpleException e) { 
			System.out.println("I caught it!"); 
		}
	}
}
