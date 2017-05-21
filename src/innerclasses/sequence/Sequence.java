package innerclasses.sequence;

import innerclasses.*;

/**
 * 内容	：
 * 说明	：
 * 作者	：zhouyf
 * 日期	：2017年5月21日	下午10:58:29
 * 
 */
interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;	//数组当前尾元素下标
    
    public Sequence(int size) {
	items = new Object[size];	
//	定义一个数组的大小
    }
    public void add(Object x) {
	if (next < items.length)
	    items[next++] = x; //添加一个数组元素后 next + 1
    }
    private class SequenceSelector implements Selector {
	//这是一个内部类:可以访问外部类的私有成员对象
	private int i = 0;
	public boolean end() {
		return i==items.length;
	}
	public Object current() {
	    return items[i];
	}
	public void next() {
	    if(i < items.length)
		i++;
	}
    }
    
    public Selector selector() {
	return new SequenceSelector();
    }
    public static void main(String[] args) {
	Sequence sequence = new Sequence(10);
	for(int i = 0; i < 10; i ++)
	    	sequence.add(Integer.toString(i));
	Selector selector = sequence.selector();
	while(!selector.end()) {
	    System.out.println(selector.current() + " ");
	    selector.next();
	}
    }

}












