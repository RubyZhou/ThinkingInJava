package 第四版_第十一章_持有对象;

import 第四版_第十四章_类型信息.pets.*;

import static 第四版_源码_util.Print.*;

/**
 * Function	: ListFeature.java
 * Author	: zhouyf
 * Date		: 2018年3月21日 
 * Version	: 1.0 
 * Desc		: List 特性
 * 			说明 : 提前使用了 typeinfo.pets 类库，包含 >
 * 					1) Pet类的继承结构
 * 					2) 随机生成 Pet 对象的工具类
 * 			=> 需了解 
 * 				1) 有一个 Pet 类，以及他的各种子类
 * 				2) 静态 Pets.arrayList() 方法返回一个已经 随机填充了 Pet 对象的ArrayList
 * History	:
 */

import java.util.*;



public class ListFeature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		/* 初始化  */
		List<Pet> pets = Pets.arrayList(7);
		print("1 : " + pets);	
		
		/* 增加 */
		Hamster h = new Hamster();
		pets.add(h);
		print("2 : " + pets);
		
		/* contains() > 是否包含 h ，返回 TRUE/FALSE */
		print("3 : " + pets.contains(h));
		
		/* remove() > 去除对象 h */
		pets.remove(h);
		print("4 : " + pets);
		
		/* get(i) > 获取第i个下标的对象 */
		Pet p = pets.get(2);
		
		/* indexof(p) > 获取对象 p 的下标  */
		print("6 : " + p + " " + pets.indexOf(p));
		
		Pet cymric = new Cymric();
		print("6 : " + pets.indexOf(cymric));	/* 如果只是值相同，是查不到的 */
		print("6 : " + pets.remove(cymric));	/* 同样，如果只是值相同，无法移除 */
		print("7 : " + pets.remove(h));
		print("8 : " + pets);
		
		/* 在指定位置插入对象 */
		pets.add(3, new Mouse());
		print("9 : " + pets);
		
		/* 获取子数组 */
		List<Pet> sub = pets.subList(1, 4);
		print("subList : " + sub);
		
		/* 是否包含子数组(顺序无关) */
		print("10 : " + pets.containsAll(sub));
		
		/* 借用工具类 Collections 类, 原地排序 */
		Collections.sort(sub);
		print("sorted subList : " + sub);
		
		/* 验证上述顺序无关 */
		print("11 : " + pets.containsAll(sub));
		
		/* 借用工具类 Collections 类, 原地打乱顺序 */
		Collections.shuffle(sub, rand);
		print("shuffle sub : " + sub);
		print("12 : " + pets.containsAll(sub));
		
		/* 复制一个对象 */
		List<Pet> copy = new ArrayList<Pet>(pets);
		print("copy : " + copy );
		
		sub = Arrays.asList(pets.get(1), pets.get(4));
		print("sub : " + sub);
		
		/* 求交集 */
		copy.retainAll(sub);
		print("13 : " + copy );
		
		copy = new ArrayList<Pet>(pets);
		copy.remove(2);
		print("14 : " + copy);
		
		copy.removeAll(sub);
		print("15 : " + copy);
		
		copy.set(1, new Mouse());
		print("16 : " + copy);
		
		copy.addAll(2, sub);
		print("17 : " + copy);
		
		print("18 : " + pets.isEmpty());
		
		pets.clear();
		print("19 : " + pets);
		print("20 : " + pets.isEmpty());

		pets.addAll(Pets.arrayList(4));
		print("21 : " + pets);
		
		Object[] o = pets.toArray();
		print("22 : " + o[3]);
		
		Pet[] pa = pets.toArray(new Pet[0]);
		print("23 : " + pa[3].id());
		
		
	}

}
