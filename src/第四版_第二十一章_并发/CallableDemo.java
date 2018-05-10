/**
 * 
 */
package 第四版_第二十一章_并发;

/**
 * Function	: CallableDemo.java
 * Author	: zhouyf
 * Date		: 2018年5月10日 
 * Version	: 1.0 
 * Desc		: 使用 Callable() 获取任务返回值
 * History	:
 */
import java.util.concurrent.*;
import java.util.*;

class TaskWithResult implements Callable<String> {
	private int id;
	public TaskWithResult(int id)	{ this.id = id; }
	public String call()			{ return "result of TaskWithResult " + id; }
}


public class CallableDemo {

	/**
	 * @param args
	 * @throws ExecutionException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		
		for (int i = 0; i < 10; i++)
			results.add(exec.submit(new TaskWithResult(i)));
		
		for (Future<String> fs : results) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
		}
	}

}
