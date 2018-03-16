package 第四版_第十一章_持有对象;

/**
 * Function	: ApplesAndOrangesWithGenerics.java
 * Author	: zhouyf
 * Date		: 2018年3月16日 
 * Version	: 1.0 
 * Desc		: 使用了泛型的ArrayList
 * 				(1) 使用了 foreach
 * History	:
 */

import java.util.*;

public class ApplesAndOrangesWithGenerics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Apple> apples = new ArrayList<Apple>();
		
		for (int i = 0; i < 3; i++) 	
			apples.add(new Apple());
		
		/* 【Error】
		 *  apples.add(new orange());
		 */
		for (int i = 0; i < 3; i++) 	
			System.out.println(apples.get(i).id());
		for (Apple c : apples)			
			System.out.println(c.id());
			
		
		
	}

}
