package 第四版_第十一章_持有对象;

/**
 * Function	: SetOperations.java
 * Author	: zhouyf
 * Date		: 2018年3月26日 
 * Version	: 1.0 
 * Desc		: Set的基本操作
 * History	:
 */
import java.util.*;
import static 第四版_源码_util.Print.*;

public class SetOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set1 = new HashSet<String>();
		Collections.addAll(set1, "A B C D E F G H I J K L".split(" "));
		set1.add("M");
		print("set1 : " + set1);
		print("H : " + set1.contains("H"));
		print("N : " + set1.contains("N"));
		
		Set<String> set2 = new HashSet<String>();
		Collections.addAll(set2, "H I J K L".split(" "));
		
		print("set2 : " + set2);
		print("set2 in set1 ? " + set1.containsAll(set2));
		System.out.println();
		
		set1.remove("H");
		print("set1 : " + set1);
		print("set2 in set1 ? " + set1.containsAll(set2));
		System.out.println();
		
		
		set1.removeAll(set2);
		print("set2 removed from set1 : " + set1);
		System.out.println();
		
		Collections.addAll(set1, "X Y Z".split(" "));
		print("X Y Z added to set1 : " + set1);
		System.out.println();
		
		
		
		
	}

}
