package 第四版_第十一章_持有对象;

import java.util.*;

import 第四版_辅助类.*;

import static 第四版_源码_util.Print.*;

public class PetMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Pet> petMap = new HashMap<String, Pet>();
		petMap.put("My cat",	 new Cat("猫星人"));
		petMap.put("My dog",	 new Dog("汪星人"));
		petMap.put("My Hamster", new Hamster("仓鼠星人"));
		print(petMap);
		Pet dog = petMap.get("My dog");
		print(dog);
		print("petMap 的key包含 My dog? > " + petMap.containsKey("My dog"));
		print("petMap 的value包含    dog? > " + petMap.containsValue("dog"));
	}

}
