package MyTest;

import java.util.ArrayList;

/**
 * Function	: MyTest_Array.java
 * Author	: zhouyf
 * Date		: 2018年3月13日
 * Version	: 1.0 
 * Desc		: 测试 两个数组 赋值的含义：即将左边的数组指向右边的数组，赋值后使用两个数组等价
 * History	:
 */



public class MyTest_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList List = new ArrayList(); 
		List.add(1); 
		List.add(2); 
		List.add(3);
		
		ArrayList a = new ArrayList();
		a.add(4);
		a.add(5);
		a.add(6);
		a = List;
		a.add(4);
		for(Object i : a) {
			List.add(i);
		}
		for(Object i : a) {
			System.out.println(i);
		}
		
	}
}
