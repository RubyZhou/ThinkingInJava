package 第四版_第十一章_持有对象;

/**
 * Function	: SortedSetOfInteger.java
 * Author	: zhouyf
 * Date		: 2018年3月26日 
 * Version	: 1.0 
 * Desc		: 使用  TreeSet 存放 Integer (结果排序)
 * History	:
 */

import java.util.*;

public class SortedSetOfInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(47);
		SortedSet<Integer> intset = new TreeSet<Integer>();
		for (int i = 0; i < 1000; i ++)
			intset.add(rand.nextInt(30));
		System.out.println(intset);
	}

}
