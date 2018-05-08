package 第四版_第十一章_持有对象;
/**
 * Function	: MapOfList.java
 * Author	: zhouyf
 * Date		: 2018年3月30日 
 * Version	: 1.0 
 * Desc		: 扩展到多个维度的 Map
 * History	:
 */

import static util.Print.*;
import java.util.*;

import 第四版_辅助类.*;

public class MapOfList {
	
	// 一个人可以有多只宠物
	public static Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();
	
	static {
		petPeople.put(new Person("Dawn"), 
						Arrays.asList(new Cymric("威尔斯猫-1"), new Mutt("小狗-1")));
		
		petPeople.put(new Person("Kate"), 
						Arrays.asList(new Cat("2喵-1"), new Cat("2喵-2"), new Dog("2汪-1")));
		
		petPeople.put(new Person("Marilyn"), 
						Arrays.asList(
									new Pug("Louie aka Louis Snorkelstein Dupree"), 
									new Cat("Stanford aka Stinky el Negro"),
									new Cat("Pinkola")));
		
		petPeople.put(new Person("Luke"), 
						Arrays.asList(new Cat("Fuzzy"), new Cat("Fizzy")));
		
		petPeople.put(new Person("Isaac"), 
						Arrays.asList(new Rat("Freckly")));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print("Person: " + petPeople.keySet());
		print("Pets : " + petPeople.values());
		print("----------------------------------");
		for (Person person : petPeople.keySet()) {
			print(person + "has");
			for(Pet pet : petPeople.get(person))
				print("\t" + pet);
			print("----------------------------------");
		}
	}

}
