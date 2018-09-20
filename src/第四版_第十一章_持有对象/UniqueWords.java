package 第四版_第十一章_持有对象;

/**
 * Function	: UniqueWords.java
 * Author	: zhouyf
 * Date		: 2018年3月26日 
 * Version	: 1.0 
 * Desc		: Set应用案列 ： 将一个文件的所有单词放入 Set 中。（爬虫功能？）
 * History	:
 */

import java.util.*;
import 第四版_源码_util.*;

public class UniqueWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> words = new TreeSet<String>(new TextFile("src\\第四版_第十一章_持有对象\\SetOperations.java", "\\W+"));
		System.out.println(words);
	}
}
