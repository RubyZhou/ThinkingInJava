package 第四版_第十章_内部类;

/**
 * Function	: TestNanoTime.java
 * Author	: zhouyf
 * Date		: 2018年3月12日
 * Version	: 1.0 
 * Desc		: 测试 System.nanoTime()
 * 					=>	返回一个随机时间点算起的毫微秒数，以毫微秒为单位。
 * 					=>	通常用于测量已过的时间 : 连续两次调用后作差
 * History	:
 */
public class TestNanoTime {
	
	private long eventTime;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println(System.nanoTime());
			
		}
			
		
	}

}
