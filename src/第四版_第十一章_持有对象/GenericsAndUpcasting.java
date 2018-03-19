package 第四版_第十一章_持有对象;

/**
 * Function	: GenericsAndUpcasting.java
 * Author	: zhouyf
 * Date		: 2018年3月16日 
 * Version	: 1.0 
 * Desc		: 带向上转型的 泛型 ArrayList
 * 				即，详细 可代替 粗略的
 * History	:
 */

import java.util.*;


class GrannySmith	extends Apple {}
class Gala			extends Apple {}
class Fuji			extends Apple {}
class BraeBurn		extends Apple {}

public class GenericsAndUpcasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Apple> apples = new ArrayList<Apple>();
		
		for (int i = 0; i < 3; i++) 	
			apples.add(new Apple());
		
		/* 向上转型的 */
		apples.add(new GrannySmith());
		apples.add(new Gala());
		apples.add(new Fuji());
		apples.add(new BraeBurn());
		
		for (Apple c : apples ) {
			System.out.println(c);
		}
	}
}
