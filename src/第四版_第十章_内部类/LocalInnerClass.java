package 第四版_第十章_内部类;

import static 第四版_源码_util.Print.*;

interface Counter {
	int next();
}

public class LocalInnerClass {

	/* 【共享的变量】 局内 & 匿内*/
	private int count = 0;
	
	/* 局部内部类 : 外部类方法中使用内部类 */
	Counter getCounter(final String name) {
		
		/* 局部内部类：  LocalCounter 实现了 Counter 接口*/
		class LocalCounter implements Counter {
			public LocalCounter()	{ print("LocalCounter()"); }
			public int next()		{ printnb(name); return count++; }
		}
		return new LocalCounter();
	}
	
	/* 匿名内部类 : 外部类方法中使用匿名内部类 */
	Counter getCounter2(final String name) {
		return new Counter() {
			{ print("Counter()"); }	//匿名内部类构造器
			public int next()	{ printnb(name); return count++; }
		};
	}
	
	public static void main(String[] args) {
		LocalInnerClass lic = new LocalInnerClass();
		/* 分别顶一个局部内部类 & 一个匿名内部类*/
		Counter
			c1 = lic.getCounter("Local inner : "),
			c2 = lic.getCounter2("Anony inner : ");

		for(int i = 0; i < 5; i++)
			print(c1.next());
		
		for(int i = 0; i < 5; i++)
			print(c2.next());

	}

}
