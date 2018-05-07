/**
 * 
 */
package 第四版_第十二章_通过异常处理错误;

/**
 * Function	: LoggingExceptions.java
 * Author	: zhouyf
 * Date		: 2018年4月26日 
 * Version	: 1.0 
 * Desc		: 异常与日志记录
 * History	:
 */
import java.util.logging.*;
import java.io.*;

class LoggingException extends Exception {
	private static Logger logger = Logger.getLogger("LoggingException");
	
	/* 构造器 ：需要从 step3 倒推来看 */
	public LoggingException() {
		
		/**
		 *  【step 1】 定义一个 StringWriter
		 */
		StringWriter trace = new StringWriter();	//StringWriter对象功能 ： 
		
		/**
		 * 【step 2】
		 * 说明：
		 * 官方解释	=>
		 * 		(1) 重载  printStackTrace() ： 原为e.printStackTrace(System.out);
		 * 		(2) 接受一个 java.io.PrintWriter 对象 : <作用> java.io.StringWriter 对象传给 PrintWriter的构造器，通过调用 toString, 就可以将输出抽取成一个 String
		 * 
		 * InMyWay	=>
		 * 		PrintWriter 作用
		 * 			在构造器中接受一个 PrintWriter 对象
		 * 			后续 PrintWriter 对象直接调用 toString 即可获取一个的 String
		 */
		printStackTrace(new PrintWriter(trace));	//重载 printStackTrace : 
		
		/**
		 * 【step 3】说明  : Logger.severe : 向 Logger 写入的最简单方式之一, 即直接调用与日志记录消息的级别相关联的方法
		 */
		logger.severe(trace.toString());	// 通过 trace.toString 生成消息
	}
}

public class LoggingExceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
		
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
		
	}

}








