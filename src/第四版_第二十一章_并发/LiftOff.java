/**
 * 
 */
package 第四版_第二十一章_并发;

/**
 * Function	: LiftOff.java
 * Author	: zhouyf
 * Date		: 2018年5月9日 
 * Version	: 1.0 
 * Desc		: 一个简单的线程任务 : (实现了 Runnale 接口) && (编写了 run() 方法)
 * History	:
 */
public class LiftOff implements Runnable{

	protected int countDown = 10;	// Default
	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public LiftOff()				{}
	public LiftOff(int countDown)	{ this.countDown = countDown; }
	
	public String status() {
		return "#" + id 
				+ "(" + (countDown > 0 ? countDown : "LiftOff!" ) + ") ";
	}

	public void run() {
		while(countDown-- > 0) {
			System.out.println(status());
			Thread.yield();		// 线程调度器 : 声明 -> 已经处理完声明周期中最重要的部分，可以将 CPU 切换给其他任务执行
		}
	}
	
}
