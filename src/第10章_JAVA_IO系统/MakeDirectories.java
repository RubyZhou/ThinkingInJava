package 第10章_JAVA_IO系统;

/**
 * File 类：除了查询现有文件外的其他用法, 包括，复制文件，删除一个文件/目录，显示文件信息
 * @author zhouyf
 *
 */
import java.io.*;

public class MakeDirectories {
	
	/**
	 * 定义一个静态变量
	 */
	private final static String usage = 
			"Usage:MakeDirectories path1 ...\n" +
					"Creates each path\n" +
					
					"Usage:MakeDirectories -d path1 ...\n" +
					"Deletes each path\n" +
					
					"Usage:MakeDirectories -r path1 path2\n" +
					"Renames from path1 to path2\n";
	
	/**
	 * 打印 Usage
	 */
	private static void usage() {
		System.err.println(usage);
		System.exit(1);
	}
	
	/**
	 * 显示 File 类的各种方法
	 * @param f
	 */
	private static void fileData(File f) {
		System.out.println(
			"---------------INFO---------------------" +
			"\n Absolute path: " + f.getAbsolutePath() +
			"\n Can read: " + f.canRead() +
			"\n Can write: " + f.canWrite() +
			"\n getName: " + f.getName() +
			"\n getParent: " + f.getParent() +
			"\n getPath: " + f.getPath() +
			"\n length: " + f.length() +
			"\n lastModified: " + f.lastModified() +
			"\n---------------INFO---------------------"
		);
		if (f.isFile())
			System.out.println(f.getName() + " is File!");
		else if (f.isDirectory())
			System.out.println(f.getName() + " is Directory!");
	}
	
	public static void main(String[] args) {
		//参数数量判断
		if (args.length < 1)
			usage();
		
		/**
		 * 	处理固定参数
		 *  Usage:MakeDirectories -r path1 path2 
		 * 	Renames from path1 to path2
		 */
		if (args[0].equals("-r")) {
			if (args.length != 3)
				usage();
			
			File old = new File(args[1]),
				 rename = new File(args[2]);
			
			old.renameTo(rename);
			fileData(old);
			fileData(rename);
			return;
		}
		
		/**
		 * 	处理可变个数的参数
		 *  Usage:MakeDirectories -d path1 ...
		 * 	Deletes each path
		 */
		// 参数计数器
		int count = 0;
		boolean del = false;
		
		if (args[0].equals("-d")) {
			count++;
			del = true;			
		}
		/**
		 * 循环处理每个文件
		 * Tips: for的第一个是空语句，在之前已经进行了 count 和 del 参数的初始化
		 */
		for ( ; count < args.length; count++) {
			File f = new File(args[count]);
			if (f.exists()) {
				System.out.println(f + "exist");
				if (del) {
					System.out.println("deleting..." + f);
					f.delete();
				}
			}
			else {
				if (!del) {
					f.mkdirs();
					System.out.println("creating...." + f);
				}
			}
			fileData(f);
		}
		
	}
	
}

















