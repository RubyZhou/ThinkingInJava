package 第10章_JAVA_IO系统;
/**
 * 从标准输入中读取数据
 * @author zhouyf
 *
 */
import java.io.*;
public class Echo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
		String s;
		try {
			while((s=in.readLine()).length() != 0) {
				System.out.println("Please input a string(quit:q):");
				System.out.println(s);
				if (s.equals("q"))
					break;
			}
			System.out.println("Bye!");
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
