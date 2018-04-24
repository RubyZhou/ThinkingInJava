package 第四版_第十一章_持有对象;
/**
 * 
 * Function	: EnvironmentVariables.java
 * Author	: zhouyf
 * Date		: 2018年4月3日 
 * Version	: 1.0 
 * Desc		: 显示所有操作系统的环境变量
 * History	:
 */
import java.util.*;
public class EnvironmentVariables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Map.Entry entry : System.getenv().entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
	}

}
