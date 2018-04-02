package 第四版_第十一章_持有对象;
/**
 * Function	: QueueDemo.java
 * Author	: zhouyf
 * Date		: 2018年3月30日 
 * Version	: 1.0 
 * Desc		: LinkedList 实现 Queue
 * History	:
 */

import java.util.*;

public class QueueDemo {
	public static void printQ(Queue queue) {
		while(queue.peek() != null)
			System.out.print(queue.remove() + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(99);
		for (int i = 0; i < 10; i++) {
			queue.offer(rand.nextInt(i + 10));
		}
		printQ(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for (char c : "Brontosaurus".toCharArray())
			qc.offer(c);
		printQ(qc);
	}

}
