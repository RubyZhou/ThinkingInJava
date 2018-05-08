/**
 * 
 */
package 第四版_第十三章_字符串;

/**
 * Function	: WhiterStringBuilder.java
 * Author	: zhouyf
 * Date		: 2018年5月8日 
 * Version	: 1.0 
 * Desc		: 使用 String 运算符 += 【vs】 使用 StringBuilder 对象的 append : StringBuilder 更简洁，+= 则依赖编译器优化
 * History	:
 */
public class WhiterStringBuilder {

	public String implicit(String[] field) {
		String result = "";
		for(int i = 0; i < field.length; i++)
			result += field[i];
		return result;
	}
	
	public String explicit(String[] field) {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < field.length; i++) 
			result.append(field[i]);
		
		return result.toString();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
