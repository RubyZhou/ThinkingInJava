package 第四版_第十一章_持有对象;

/**
 * Function	: SetOfInteger.java
 * Author	: zhouyf
 * Date		: 2018年3月26日 
 * Version	: 1.0 
 * Desc		: 使用 HashSet 存放 Integer (结果不排序？)
 * History	:
 */

import java.util.*;



public class SetOfInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(47);
		Set<Integer> intset = new HashSet<Integer>();
		
		for(int i = 0; i < 1000; i++) {
			intset.add(rand.nextInt(30));
		}
		System.out.println(intset);
	}
}
//Output : 插了100次，就算失败的，从概率上来说也将 30 个数都命中过； 输出结果是排序的，所以显示 0 - 29
//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]

