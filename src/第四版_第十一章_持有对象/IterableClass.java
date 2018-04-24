package 第四版_第十一章_持有对象;
/**
 * 
 * Function	: IterableClass.java
 * Author	: zhouyf
 * Date		: 2018年4月3日 
 * Version	: 1.0 
 * Desc		: 任何 Iterable 类都可以使用 foreach : Iterable 接口包含了产生 Iterator 的 iterator() 方法
 * History	:
 */
import java.util.*;

public class IterableClass implements Iterable<String>{
	
	protected String[] words = ("And that is how " + "we know the Earth to be banana-shaped").split(" ");

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<String>() {
			private int index = 0;
			public boolean hasNext() { return index < words.length; }
			public String next()	 { return words[index++]; }
			public void remove()	 { throw new UnsupportedOperationException(); }
		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (String s : new IterableClass()) {
			System.out.println(s + " ");
		}
	}
}
