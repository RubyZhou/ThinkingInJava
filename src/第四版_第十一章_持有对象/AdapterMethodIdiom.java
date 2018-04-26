/**
 * 
 */
package 第四版_第十一章_持有对象;

/**
 * Function	: AdapterMethodIdiom.java
 * Author	: zhouyf
 * Date		: 2018年4月24日 
 * Version	: 1.0 
 * Desc		: 适配器方法
 * History	:
 */

import java.util.*;

class ReversibleArrayList<T> extends ArrayList<T> {
	public ReversibleArrayList(Collection<T> c)	{ super(c); }
	
	public Iterable<T> reversed() {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size() - 1;
					public boolean hasNext()	{ return current > -1; }
					public T next()				{ return get(current--); }
					public void remove()		{ throw new UnsupportedOperationException(); }
				};
			}
		};
	}
}

public class AdapterMethodIdiom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
