package 第10章_JAVA_IO系统;
import java.io.*;

/**
 * @Function 显示文件目录 3.0
 * @author zhouyf
 *
 */
public class DirList3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File path = new File(".");
			String[] list;
			if(args.length == 0)
				list = path.list();
			else
			{
				list = path.list(new FilenameFilter() {
									public boolean accept(File dir, String n) {
										String f = new File(n).getName();
										return f.indexOf(args[0]) != -1;
									}
								}
						);
			}
			for(int i = 0; i < list.length; i++)
				System.out.println(list[i]);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
