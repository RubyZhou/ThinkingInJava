package 第四版_第十一章_持有对象;

import static util.Print.*;

/**
 * Function	: ListIteration.java
 * Author	: zhouyf
 * Date		: 2018年3月23日 
 * Version	: 1.0 
 * Desc		: listIterator  的基本用法，继承自 Iterator
 * History	:
 */

import java.util.*;

import 第四版_辅助类.*;

public class ListIteration {

	public static void main(String[] args) {

		List<Pet> pets = Pets.arrayList(8);
		ListIterator<Pet> it = pets.listIterator();
		
		print(pets);
		while (it.hasNext())
			System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
		
		while (it.hasPrevious())
			System.out.println(it.previous().id() + " " );
		
		System.out.println();
		System.out.println(pets);
		
		it = pets.listIterator(3);
		while (it.hasNext()) {
			it.next();
			it.set(Pets.randomPet());
		}
		System.out.println(pets);
	}

}
