/**
 * 
 */
package 第四版_第二十一章_并发;

/**
 * Function	: MainThread.java
 * Author	: zhouyf
 * Date		: 2018年5月9日 
 * Version	: 1.0 
 * Desc		: 用  main() 方式 单线程调度
 * History	:
 */
public class MainThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LiftOff launch = new LiftOff();
		launch.run();
	}

}
