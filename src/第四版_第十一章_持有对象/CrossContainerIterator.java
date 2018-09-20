package 第四版_第十一章_持有对象;

/**
 * Function	: CrossContainerIterator.java
 * Author	: zhouyf
 * Date		: 2018年3月23日 
 * Version	: 1.0 
 * Desc		: 验证了迭代器统一对容器的访问方式
 * History	:
 */

import java.util.*;

import 第四版_辅助类.*;


public class CrossContainerIterator {

	public static void display(Iterator<Pet> it) {
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 用不同容器存放 pets */
		ArrayList<Pet>	pets	= Pets.arrayList(8);
		LinkedList<Pet>	petsLL	= new LinkedList<Pet>(pets);
		HashSet<Pet>	petsHS	= new HashSet<Pet>(pets);
		TreeSet<Pet>	petsTS	= new TreeSet<Pet>(pets);
		
		display(pets.iterator());
		display(petsLL.iterator());
		display(petsHS.iterator());
		display(petsTS.iterator());
		
	}

}
