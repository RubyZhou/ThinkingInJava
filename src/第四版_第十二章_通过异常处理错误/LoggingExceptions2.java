/**
 * 
 */
package 第四版_第十二章_通过异常处理错误;

/**
 * Function	: LoggingExceptions2.java
 * Author	: zhouyf
 * Date		: 2018年5月7日 
 * Version	: 1.0 
 * Desc		: 在异常处理程序中生成日志消息 ( 使用 日志logException 生成错误信息 )
 * History	:
 */

import java.util.logging.*;
import java.io.*;

public class LoggingExceptions2 {

	private static Logger logger = Logger.getLogger("LoggingExceptions2");
	
	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			throw new NullPointerException();
		} catch(NullPointerException e) {
			logException(e);
		}
	}

}
