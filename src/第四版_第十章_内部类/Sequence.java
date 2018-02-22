package 第四版_第十章_内部类;

/**
 * Function	: 
 * Author	: 
 * Date		: [2018-02-20]
 * Desc		: Holds a sequence of Objects.
 * History	:
 */

/*
 * 设计模式：迭代器接口
 */
interface Selector {
	boolean	end();
	Object	current();
	void	next();
}

public class Sequence {
	private Object[]	items;
	private int			next = 0;
	
	// !@创建 N 个 Object 对象容器【数组】
	public Sequence(int size) { items = new Object[size]; }

	 // @将 Object 对象赋值给第 i 个Object，并且序号 + 1
	public void add(Object x) {
		if (next < items.length)	// next 不超过 items 的大小
			items[next++] = x;
	}
	
	/*
	 * 通过内部类对外部类的元素 items 进行访问
	 * 1) 内部类继承接口 => 需要实现三个方法
	 */
	private class SequenceSelector implements Selector {
		private int i = 0;
		// @判断是否为最后一个元素
		public boolean end()	{ return i == items.length ; }
		// @取当前元素
		public Object current()	{ return items[i] ; }
		// @取下一个元素
		public void next()		{ if ( i < items.length ) i++; }
	}
	
	/*
	 * 该方法供外部调用内部类的引用
	 */
	public Selector selector() {
		return new SequenceSelector();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1) 创建十个外部类对象
		Sequence sequence = new Sequence(10);	
		
		//2) 给外部类的十个对象赋值
		/*	
		 *	Tips : 类型转换 int->string : Integer.toString(i) 
		 */
		for (int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		
		//3) 通过外部类的方法，进行创建一个接口【以内部类的方式实现的】
		Selector selector = sequence.selector();
		
		//4) 循环输出内部类所访问到的对象 ：如果不为最后一个元素, 则继续遍历
		while(!selector.end()) {
			System.out.println(selector.current() + " ");
			selector.next();
		}
	}
}
