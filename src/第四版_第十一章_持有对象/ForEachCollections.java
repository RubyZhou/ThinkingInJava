package 第四版_第十一章_持有对象;
/**
 * 
 * Function	: ForEachCollections.java
 * Author	: zhouyf
 * Date		: 2018年4月3日 
 * Version	: 1.0 
 * Desc		: foreach应用在任何 Collection
 * History	:
 */

import java.util.*;

public class ForEachCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<String> cs = new LinkedList<String>();
		Collections.addAll(cs, "Take the long way home".split(" "));
		for (String s : cs)
			System.out.println("'" + s + "' ");
		
	}

}
