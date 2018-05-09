/**
 * 
 */
package 第四版_第二十一章_并发;

import java.util.concurrent.Executors;

/**
 * Function	: SingleThreadExecutor.java
 * Author	: zhouyf
 * Date		: 2018年5月9日 
 * Version	: 1.0 
 * Desc		: 线程数为 1 的 FixedThreadPool : 序列化任务
 * History	:
 */
import java.util.concurrent.*;
public class SingleThreadExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}

}
