package 第四版_第十一章_持有对象;
/**
 * Function	: InterfaceVsIterator.java
 * Author	: zhouyf
 * Date		: 2018年4月2日 
 * Version	: 1.0 
 * Desc		: 处理容器迭代： Iterator vs. 宽接口 Collection
 * History	:
 */

import java.util.*;

import 第四版_辅助类.*;

public class InterfaceVsIterator {
	
	/**
	 * 定义两个通用的遍历方法
	 * @param it
	 */
	public static void display(Iterator<Pet> it) {
		while(it.hasNext()) {
			Pet p = it.next();
			System.out.print(p.id() + " : " + p + " ");
		}
		System.out.println();
	}
	// 用一个宽类型的接口 Collection 迭代，使用 foreach 来处理 display 更简洁
	public static void display(Collection<Pet> pets) {
		for (Pet p : pets)
			System.out.print(p.id() + " : " + p + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pet> petList		= Pets.arrayList(8);
		Set<Pet>  petSet		= new HashSet<Pet>(petList);
		
		Map<String, Pet> petMap	= new LinkedHashMap<String, Pet>();
		String[] names	= ("Ralph, Eric, Robin, Lacey, Britney, Sam, Spot, Fluffy").split(", ");
		for (int i = 0; i < names.length; i++)
			petMap.put(names[i], petList.get(i));
		
		display(petList);
		display(petSet);
		display(petList.iterator());
		display(petSet.iterator());
		System.out.println(petMap);
		System.out.println(petMap.keySet());
		System.out.println(petMap.values());
		display(petMap.values());
		display(petMap.values().iterator());

	}

}
