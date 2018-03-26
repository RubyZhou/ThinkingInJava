package 第四版_第十一章_持有对象;


/**
 * Function	: Stack.java
 * Author	: zhouyf
 * Date		: 2018年3月23日 
 * Version	: 1.0 
 * Desc		: 用 LinkedList 实现 Stack
 * 				说明	: 这里只需要栈的行为，因为使用组合代替继承!
 * History	:
 */

import java.util.*;

public class Stack<T> {
	
	private LinkedList<T> storage = new LinkedList<T>();
	
	public void push(T v)	{ storage.addFirst(v); }
	public T	peek()		{ return storage.getFirst(); }
	public T	pop()		{ return storage.removeFirst(); }
	public boolean empty()	{ return storage.isEmpty(); }
	public String toString()	{ return storage.toString(); }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();
		for (String s : "My cat has miao,miao,miao~".split(" "))
			stack.push(s);
		
		while(!stack.empty())
			System.out.println(stack.pop() + " ");
	}

}
