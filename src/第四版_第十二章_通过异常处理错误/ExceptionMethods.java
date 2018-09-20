/**
 * 
 */
package 第四版_第十二章_通过异常处理错误;

/**
 * Function	: ExceptionMethods.java
 * Author	: zhouyf
 * Date		: 2018年5月7日 
 * Version	: 1.0 
 * Desc		: 使用 Exception 捕获所有异常
 * History	:
 */

import static 第四版_源码_util.Print.*;

public class ExceptionMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			throw new Exception("My Exception");
		} catch (Exception e) {
			print("Caught Exception.");
			print("getMessage() : " + e.getMessage());
			print("getLocalizedMessage() : " + e.getLocalizedMessage());
			print("toString() : " + e.toString());
			print("printStackTrace() >>> ");
			e.printStackTrace(System.out);
		}
	}

}
