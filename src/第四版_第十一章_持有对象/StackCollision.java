package 第四版_第十一章_持有对象;

/**
 * Function	: StackCollision.java
 * Author	: zhouyf
 * Date		: 2018年3月26日 
 * Version	: 1.0 
 * Desc		: 同时使用  第四版_源码_util 中的 Stack 和 java.第四版_源码_util 中的 Stack (使用时添加包名 -> java.第四版_源码_util.Stack<String> stack)
 * History	:
 */

public class StackCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 使用 第四版_源码_util 中的 Stack (需要添加包名)
		第四版_源码_util.Stack<String> stack = new 第四版_源码_util.Stack<String>();
		for (String s : "My dog has fleas.".split(" "))
			stack.push(s);
		
		while (!stack.empty())
			System.out.println(stack.pop() + " ");
		
		System.out.println();
		
		// 使用  java.第四版_源码_util 中的 Stack
		java.util.Stack<String> stack2 = new java.util.Stack<String>();
		
		for (String s : "My dog has fleas.".split(" "))
			stack2.push(s);
		
		while(!stack2.empty())
			System.out.println(stack2.pop() + " ");
		System.out.println();
		
	}
}
