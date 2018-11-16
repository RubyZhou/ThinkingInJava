package 第四版_第十一章_持有对象;
import java.util.*;

import 第四版_第十四章_类型信息.pets.Pet;
import 第四版_第十四章_类型信息.pets.Pets;

public class CollectionSequence extends AbstractCollection<Pet>{

	private Pet[] pets = Pets.createArray(8);
	
	@Override
	public int size() { return pets.length;	}
	
	@Override
	public Iterator<Pet> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Pet>() {
			private int index = 0;
			public boolean hasNext()	{ return index < pets.length; }
			public Pet next()			{ return pets[index++]; }
			public void remove()		{ throw new UnsupportedOperationException(); }
		
		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionSequence c = new CollectionSequence();
		InterfaceVsIterator.display(c);
		InterfaceVsIterator.display(c.iterator());

	}	

}
