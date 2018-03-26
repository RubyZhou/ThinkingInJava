package 第四版_第十一章_持有对象;
/**
 * Function	: UniqueWordsAlphabetic.java
 * Author	: zhouyf
 * Date		: 2018年3月26日 
 * Version	: 1.0 
 * Desc		: 按字母顺序排序，不区分大小写
 * 				注：上例是按先大写后小写方式排序
 * History	:
 */

import java.util.*;
import util.*;

public class UniqueWordsAlphabetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用比较器
		Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		words.addAll(new TextFile("src\\第四版_第十一章_持有对象\\SetOperations.java", "\\W+"));
		System.out.println(words);

	}

}
