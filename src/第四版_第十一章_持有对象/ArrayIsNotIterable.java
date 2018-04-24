package 第四版_第十一章_持有对象;
/**
 * 
 * Function	: ArrayIsNotIterable.java
 * Author	: zhouyf
 * Date		: 2018年4月24日 
 * Version	: 1.0 
 * Desc		: 数组 不是 Iterable，无法自动转换
 * History	:
 */
import java.util.*;

public class ArrayIsNotIterable {
	
	static <T> void test(Iterable<T> ib) {
		for (T t : ib)
			System.out.println(t + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(Arrays.asList(1, 2, 3));
		String[] strings = {"A", "B", "C"};
		// 将上述 数组 string 当作一个 Iterable 参数传递会导致失败 <=> 不存在 [数组] to [Iterable] 的自动转换 
		//! test(strings);
		// 必须手动转换
		test(Arrays.asList(strings));
	}

}
