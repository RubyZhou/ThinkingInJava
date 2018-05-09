/**
 * 
 */
package 第四版_第二十一章_并发;

/**
 * Function	: BasicThreads.java
 * Author	: zhouyf
 * Date		: 2018年5月9日 
 * Version	: 1.0 
 * Desc		: 通过 Threads 来驱动 任务 : 本例创建了一个线程去执行 LiftOff.run(), 原 main() 线程与其同步执行
 * History	:
 */
public class BasicThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new LiftOff());
		t.start();
		System.out.println("Waiting for LiftOff");
	}

}
