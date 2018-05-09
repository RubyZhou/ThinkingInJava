/**
 * 
 */
package 第四版_第二十一章_并发;

/**
 * Function	: FixedThreadPool.java
 * Author	: zhouyf
 * Date		: 2018年5月9日 
 * Version	: 1.0 
 * Desc		: FixedThreadPool(int i) ：可以设置有限的线程池数量
 * History	:
 */
import java.util.concurrent.*;

public class FixedThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}

}
