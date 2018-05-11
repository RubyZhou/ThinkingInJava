/**
 * 
 */
package 第四版_第二十一章_并发;

import java.util.concurrent.Executors;

/**
 * Function	: SimplePriorities.java
 * Author	: zhouyf
 * Date		: 2018年5月11日 
 * Version	: 1.0 
 * Desc		: 线程优先级
 * History	:
 */

import java.util.concurrent.*;

public class SimplePriorities implements Runnable{

	private int	countDown = 5;	//countDown:
	private int	priority;
	private volatile double	d ;
		
	public SimplePriorities(int priority)	{ this.priority= priority; }
	
	public String toString()	{ return Thread.currentThread() + ":" + countDown; }
	
	public void run() {
		Thread.currentThread().setPriority(priority);
		while(true) {
			/*
			 * 复杂的浮点运算，确保优先级效果可以观察
			 */
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double)i;
				if (i % 1000 == 0)	{ Thread.yield(); }
			}
			
			System.out.println(this);
			
			if(--countDown == 0)	{ return; }
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		
		/* 1-5 号线程 */
		for (int i = 0; i < 5; i++)
			exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		
		/* 6号线程 */
		exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		exec.shutdown();

	}

}
