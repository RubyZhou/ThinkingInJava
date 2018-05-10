/**
 * 
 */
package 第四版_第二十一章_并发;

/**
 * Function	: SleepingTask.java
 * Author	: zhouyf
 * Date		: 2018年5月10日 
 * Version	: 1.0 
 * Desc		: 带休眠的任务
 * History	:
 */

import java.util.concurrent.*;

public class SleepingTask extends LiftOff{
	public void run() {
		try {
			while(countDown-- > 0) {
				System.out.println(status());
				// old style : 
				// Thread.sleep(100);
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.err.println("Interrupted");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SleepingTask());
		}
		exec.shutdown();
	}
}
