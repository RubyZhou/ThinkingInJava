/**
 * 
 */
package 第四版_第十三章_字符串;

/**
 * Function	: Immutable.java
 * Author	: zhouyf
 * Date		: 2018年5月8日 
 * Version	: 1.0 
 * Desc		: String对象不变性 : 使用 String 只会 copy 一份引用，不是通过地址传值 => 原 String不变
 * History	:
 */
import static util.Print.*;

public class Immutable {

	public static String upcase(String s) {
		return s.toUpperCase();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String q = "howdy";
		print(q);
		System.out.println("----------------");
		String qq = upcase(q);
		print(qq);
		print(q);
		System.out.println("----------------");
		q = "HOWDY1";
		print(q);
		System.out.println("----------------");
		
	}

}
