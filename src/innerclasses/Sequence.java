package innerclasses;
/**
 * 内容	：通过内部类访问外部类元素
 * 说明	: 运用了 迭代器 模式
 * 作者	：zhouyf
 * 日期	：2017年6月10日	下午5:32:21
 * 
 */

public class Sequence {
    private Object[] items;
    private int next = 0;
    
    public Sequence(int size) {
	// 外部类的构造器 : 创建一个数组
	items = new Object[size];
    }
    
    public void add(Object x) {
	if (next < items.length) {
	    items[next++] = x;	//将 新元素 增加至数组尾部，并且 游标 + 1
	}
    }
    
    /**
     * 创建一个内部类
     */
    private class SequenceSelector implements Selector {
		//内部类实现了迭代器接口
	private int i = 0;

	@Override
	/**
	 * 1.这里调用了外部类的 items
	 * 2.直接return 一个条件表达式，没有多余操作 (good!)
	 */
	public boolean end() {
	    
	    return i == items.length;	
	}

	@Override
	/**
	 * 这里也是调用了外部类的 items
	 */ 
	public Object current() {
	    return items[i];
	}

	@Override
	/**
	 * 游标走一步
	 */
	public void next() {
	    if (i < items.length)
		i++;
	}
	
    }

    /**
     * 创建一个内部类对象并且返回接口 < 对client来说是针对接口编程而非实现 >
     * @return
     */
    public Selector selector() {
	return new SequenceSelector();
    }
    

    public static void main(String[] args) {
	/**
	 * 创建一个数组，Sequence 提供一个迭代器进行对数组元素的访问
	 */
	Sequence sequence = new Sequence(10);
	
	for (int i = 0; i < 10; i++) {	/* 向数组插入数据 */
	    sequence.add(Integer.toString(i)); /* integer 转化为 string : Integer.toString((int)var) */
	}
	
	Selector selector = sequence.selector();
	
	while(!selector.end()) {
	    /* 循环取数 */
	    System.out.println(selector.current() + " ");
	    selector.next();
	}
    }

}







