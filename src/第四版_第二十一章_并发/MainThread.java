/**
 * 
 */
package 第四版_第二十一章_并发;

/**
 * Function	: MainThread.java
 * Author	: zhouyf
 * Date		: 2018年5月9日 
 * Version	: 1.0 
 * Desc		: 【单线程调度】 ：通过  main() 线程完成 LiftOff.run()
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
