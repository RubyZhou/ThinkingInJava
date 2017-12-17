package 第10章_JAVA_IO系统;

/**
 * Function : 以装饰器模式，从输入文件读取数据，输出到输出文件
 */
import java.io.*;
public class selfcode_InToOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DataInputStream in = 
					new DataInputStream(
							new BufferedInputStream(
									new FileInputStream("C:\\Users\\zhouyf\\Desktop\\资料\\temp\\kms10.log")));
			
			PrintStream out = 
					new PrintStream(
							new BufferedOutputStream(
									new FileOutputStream("C:\\Users\\zhouyf\\Desktop\\资料\\temp\\testout.txt")));
			
			String s = new String();
			LineNumberInputStream li = new LineNumberInputStream(in);
			DataInputStream inForLine = new DataInputStream(li);
			
			while ((s = inForLine.readLine()) != null)
			{	
				out.println("Line " + li.getLineNumber() + " : " + s);
			}
			out.close();
		}catch (IOException e) {
			System.err.println("IOException");
		}
	}

}
