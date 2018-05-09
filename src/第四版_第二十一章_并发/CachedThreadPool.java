/**
 * 
 */
package 第四版_第二十一章_并发;

/**
 * Function	: CachedThreadPool.java
 * Author	: zhouyf
 * Date		: 2018年5月9日 
 * Version	: 1.0 
 * Desc		: 使用 Executor 管理线程（线程池）
 * History	:
 */

import java.util.concurrent.*;

public class CachedThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}

}
