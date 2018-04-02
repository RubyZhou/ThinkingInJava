package 第四版_第十一章_持有对象;
/**
 * Function	: CollectionSequence.java
 * Author	: zhouyf
 * Date		: 2018年4月2日 
 * Version	: 1.0 
 * Desc		: 继承AbstractCollection 不如 使用Iterator的案例
 * 			继承抽象类 AbstractCollection 必须实现他的方法，并且不能再继承其他类，使用 Iterator 性价比更高
 * History	:
 */
import 第四版_第十一章_持有对象_辅助类typeinfo.*;
import java.util.*;

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
