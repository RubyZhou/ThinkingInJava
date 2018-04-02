package 第四版_第十一章_持有对象;
/**
 * Function	: PriorityQueueDemo.java
 * Author	: zhouyf
 * Date		: 2018年4月2日 
 * Version	: 1.0 
 * Desc		: 优先级队列
 * History	:
 */

import java.util.*;
import util.*;


public class PriorityQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			priorityQueue.offer(rand.nextInt(i + 10));
		}
		System.out.println("插入顺序 : " + "\n" + priorityQueue);
		System.out.println("队列顺序 : ");
		QueueDemo.printQ(priorityQueue);
		System.out.println("----------------<Integer：默认>---------------------------");
		
		List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
		priorityQueue = new PriorityQueue<Integer>(ints);
		System.out.println("插入顺序 : " + "\n" + priorityQueue);
		System.out.println("队列顺序 : ");
		QueueDemo.printQ(priorityQueue);
		
		System.out.println("----------------<Integer：倒序>--------------------------");
		priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());	//倒序
		priorityQueue.addAll(ints);
		System.out.println("插入顺序 : " + "\n" + priorityQueue);
		System.out.println("队列顺序 : ");
		QueueDemo.printQ(priorityQueue);
		
		System.out.println("--------------------<字符串：默认>-----------------------");
		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(" "));
		PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
		System.out.println("插入顺序 : " + "\n" + stringPQ);
		System.out.println("队列顺序 : ");
		QueueDemo.printQ(stringPQ);
		
		System.out.println("-------------------<字符串：倒序>------------------------");
		stringPQ = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
		stringPQ.addAll(strings);
		System.out.println("插入顺序 : " + "\n" + stringPQ);
		System.out.println("队列顺序 : ");
		QueueDemo.printQ(stringPQ);
		
		System.out.println("-------------------<字符：>------------------------");
		// 先将字符串按字符分割装入 Set
		Set<Character> charSet = new HashSet<Character>();
		for (char c : fact.toCharArray())
			charSet.add(c);
		PriorityQueue characterPQ = new PriorityQueue<Character>(charSet);
		System.out.println("插入顺序 : " + "\n" + characterPQ);
		System.out.println("队列顺序 : ");
		QueueDemo.printQ(characterPQ);
		
	}

}
