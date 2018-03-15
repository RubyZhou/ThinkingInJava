package 第四版_第十一章_持有对象;

/** 
 * Function	: ApplesAndOrangesWithoutGenerics.java
 * Author	: zhouyf
 * Date		: 2018年3月15日 
 * Version	: 1.0 
 * Desc		: 【证明】向 ArrayList 放入不同类型的变量会导致异常
 * 				(1) ArrayList 的基本用法
 * 				(2) @SuppressWarnings("unchecked") -> @开头表示注解，表示抑制 "不受检查的异常" 的警告信息
 * 
 * History	:
 */
// {ThrowsException}
import java.util.*;


class Apple {
	private	static long counter;
	private	final long id = counter++;
	public	long id()	{ return id; }
}

class orange {}

public class ApplesAndOrangesWithoutGenerics {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList apples = new ArrayList();
		
		/* 向容器中添加 3 个苹果 */
		for (int i = 0; i < 3; i++)
			apples.add(new Apple());
		
		/* 再容器中添加 1 个橘子 */
		apples.add(new orange());
		
		for ( int i = 0; i < apples.size(); i++)
			((Apple)apples.get(i)).id();
	}		
}
