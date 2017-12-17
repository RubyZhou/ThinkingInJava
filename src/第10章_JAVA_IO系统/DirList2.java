package 第10章_JAVA_IO系统;
import java.io.*;


public class DirList2 {
	
	/**
	 * 这是一个内部类
	 * @param afn
	 * @return
	 * FilenameFilter：文件名过滤器接口，必须实现 boolean accept(文件目录， 字符串)
	 */
	public static FilenameFilter filter(final String afn) {	
										//匿名内部类：必须是final，可以使用外部对象
		return new FilenameFilter() {
			String fn = afn;
			public boolean accept(File dir, String n) {
				String f = new File(n).getName();
				return f.indexOf(fn) != -1;
			}
		};
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File path = new File(".");
			String[] list;
			
			if(args.length == 0)
				list = path.list();
			else
				list = path.list(filter(args[0]));
			
			for(int i = 0; i < list.length; i++)
				System.out.println(list[i]);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
