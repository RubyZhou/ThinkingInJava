package 第四版_第十一章_持有对象;

/**
 * Function	: PrintContainers.java
 * Author	: zhouyf
 * Date		: 2018年3月19日 
 * Version	: 1.0 
 * Desc		: 容器的打印
 * History	:
 */

import java.util.*;
import static util.Print.*;


public class PrintContainers {
	
	/**
	 * 基本逻辑：传入一个容器实例 -> 填值 -> 返回
	 */
	static Collection fill(Collection<String> collection) {
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}
	
	static Map fill(Map<String, String> map) {
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		return map;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(fill(new ArrayList<String>()));
		print(fill(new LinkedList<String>()));
		print(fill(new HashSet<String>()));
		print(fill(new TreeSet<String>()));
		print(fill(new LinkedHashSet<String>()));
		
		print(fill(new HashMap<String, String>()));
		print(fill(new TreeMap<String, String>()));
		print(fill(new LinkedHashMap<String, String>()));
	}

}
