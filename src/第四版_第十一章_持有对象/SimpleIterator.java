package 第四版_第十一章_持有对象;

/**
 * Function	: SimpleIterator.java
 * Author	: zhouyf
 * Date		: 2018年3月23日 
 * Version	: 1.0 
 * Desc		: 简单的迭代器使用
 * History	:
 */

import java.util.*;
import static util.Print.*;
import 第四版_第十一章_持有对象_辅助类typeinfo.*;


public class SimpleIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pet> pets = Pets.arrayList(12);
		System.out.println(pets);
		
		System.out.println("---------------------------------------");
		Iterator<Pet> it = pets.iterator();
		while(it.hasNext()) {
			Pet p = it.next();
			System.out.println(p.id() + ":" + p + " ");
		}
		
		System.out.println("---------------------------------------");
		for (Pet p : pets)
			System.out.println(p.id() + ":" + p + " ");
		
		System.out.println(pets);
		System.out.println("---------------------------------------");
		it = pets.iterator();	// 重设迭代器
		for (int i = 0; i <= 6; i++) {
			it.next();
			it.remove();
		}
		
		System.out.println(pets);
		
	}

}
