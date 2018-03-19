package 第四版_第十一章_持有对象;

/**
 * Function	: SimpleCollection.java
 * Author	: zhouyf
 * Date		: 2018年3月19日 
 * Version	: 1.0 
 * Desc		: 简单的序列 Collection 示例
 * 				用 Integer 填充 Collection
 * History	:
 */

import java.util.*;

public class SimpleCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Integer> c = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			c.add(i);
		
		for (Integer i : c)
			System.out.print(i + ", ");
	}
}
