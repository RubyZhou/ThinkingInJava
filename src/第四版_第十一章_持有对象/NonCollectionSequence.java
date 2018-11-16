package 第四版_第十一章_持有对象;
/**
 * Function	: NonCollectionSequence.java
 * Author	: zhouyf
 * Date		: 2018年4月2日 
 * Version	: 1.0 
 * Desc		: 
 * History	:
 */

import java.util.*;

import 第四版_第十四章_类型信息.pets.Pet;
import 第四版_第十四章_类型信息.pets.Pets;

class PetSequence {
	protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence {

	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index = 0;
			public boolean hasNext()	{ return index < pets.length; }
			public Pet next()			{ return pets[index++]; }
			public void remove()		{ throw new UnsupportedOperationException(); }
		};
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonCollectionSequence nc = new NonCollectionSequence();
		InterfaceVsIterator.display(nc.iterator());
	}

}
