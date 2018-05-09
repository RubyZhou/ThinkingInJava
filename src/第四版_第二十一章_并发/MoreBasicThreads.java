/**
 * 
 */
package 第四版_第二十一章_并发;

/**
 * Function	: MoreBasicThreads.java
 * Author	: zhouyf
 * Date		: 2018年5月9日 
 * Version	: 1.0 
 * Desc		: 【5个线程调度】：结果非确定性
 * History	:
 */
public class MoreBasicThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting for LiftOff");
	}

}
