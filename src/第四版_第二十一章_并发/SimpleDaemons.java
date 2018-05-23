/**
 * 
 */
package 第四版_第二十一章_并发;

/**
 * Function	: SimpleDaemons.java
 * Author	: zhouyf
 * Date		: 2018年5月23日 
 * Version	: 1.0 
 * Desc		: 后台线程 <setDaemon(true)>
 * History	:
 */

import java.util.concurrent.*;
import util.Print.*;

public class SimpleDaemons implements Runnable{
	
	public void run() {
		try {
			while(true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			System.out.println("sleep() interrupted");
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TimeUnit.MILLISECONDS.sleep(100);
		for (int i = 0; i < 10; i++) {
			Thread Daemon = new Thread(new SimpleDaemons());
			Daemon.setDaemon(true);	//必须在
			Daemon.start();			
		}
		System.out.println("All Daemons has been started!");
		TimeUnit.MILLISECONDS.sleep(175);
		System.out.println("Finished!");
	}

}
