package 第10章_JAVA_IO系统;

/**
 * 测试格式化内层输入:一次读取一个字符
 * @author zhouyf
 *
 */

import java.io.*;

public class TestEOF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\开发工具\\JAVA安装.txt")));
			/**
			 * 用available()方法判断有多少字符可用
			 */
			while (in.available() != 0)
				System.out.println(in.readLine());
		}catch (IOException e) {
			System.err.println("IOException");
		}
	}

}
