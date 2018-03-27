package 第四版_第十一章_持有对象;

/**
 * Function	: Statistics.java
 * Author	: zhouyf
 * Date		: 2018年3月27日 
 * Version	: 1.0 
 * Desc		: Map的基本用法测试随机数分布
 * History	:
 */
import java.util.*;

public class Statistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(47);
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10000; i++) {
			int r = rand.nextInt(20);
			Integer freq = m.get(r);	// 尝试获取 Map 中 key为 r 的值，获取失败会返回null
			m.put(r, freq == null ? 1 : freq + 1);
		}
		System.out.println(m);
	}
}
