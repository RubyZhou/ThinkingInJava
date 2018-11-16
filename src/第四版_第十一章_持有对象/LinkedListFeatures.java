package 第四版_第十一章_持有对象;

import 第四版_第十四章_类型信息.pets.Hamster;
import 第四版_第十四章_类型信息.pets.Pet;
import 第四版_第十四章_类型信息.pets.Pets;
import 第四版_第十四章_类型信息.pets.Rat;

import static 第四版_源码_util.Print.*;

/**
 * Function	: LinkedListFeatures.java
 * Author	: zhouyf
 * Date		: 2018年3月23日 
 * Version	: 1.0 
 * Desc		: LinkedList 的基本特性
 * History	:
 */

import java.util.*;



public class LinkedListFeatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
		print(pets);
		
		print("---------------------");
		print("pets.getFirst() : " + pets.getFirst());
		print("pets.elements() : " + pets.element());
		print("pets.peek()	: " + pets.peek());
		print("---------------------");
		print("pets.remove() : " + pets.remove());
		print("pets.removeFirst() : " + pets.removeFirst());
		print("pets.poll() : " + pets.poll());
		print("---------------------");
		print(pets);
		print("---------------------");
		pets.addFirst(new Rat());
		print("After addFirst() : " + pets);
		pets.offer(Pets.randomPet());
		print("After offer() : " + pets);
		pets.add(Pets.randomPet());
		print("After add() : " + pets);
		pets.addLast(new Hamster());
		print("After addLast : " + pets);
		print("pets.removeLast() : " + pets.removeLast());
		print("pets : " + pets);
		
		
		
		
	}

}
