package 第四版_第十一章_持有对象;

/**
 * Function	: AddingGroups.java
 * Author	: zhouyf
 * Date		: 2018年3月19日 
 * Version	: 1.0 
 * Desc		: 添加一组元素的多种方法比较
 * History	:
 */

import java.util.*;

public class AddingGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 基本款，使用 Arrays.asList( ) 作为参数传给一个ArrayList  的构造器*/
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		
		/* 
		 * 低性价比款, 使用 Collection.addAll() 
		 * 		①. 缺点 : 参数不可变 ：collection.addAll( ) 只能接收 collection 对象的参数
		 */
		Integer[] moreInts = {6, 7, 8, 9, 10};
		collection.addAll(Arrays.asList(moreInts));
		
		/* 灵活款【首选】，使用 Collections.addAll() */
		Collections.addAll(collection, 11, 12, 13, 14, 15);
		Collections.addAll(collection, moreInts);
		
		/*
		 * 省事挖坑款，直接使用 Arrays.asList()
		 * 		①. 缺点 : 长度固定 ：不能调整数组大小, 无法 add( ) / delete( )
		 */
		List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
		list.set(1, 99);
		
		
		
		System.out.println("\n-------------------");
		for (Integer i : collection)
			System.out.print(i +  ",");
		
		System.out.println("\n-------------------");
		for (Integer i : list)
			System.out.print(i +  ",");
		

		
	}

}
