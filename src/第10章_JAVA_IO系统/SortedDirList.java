package 第10章_JAVA_IO系统;

import java.io.*;
import copy_第8章_对象的容纳.*;

/**
 * # copy #
 * 顺序目录列表
 * @author zhouyf
 *
 */
public class SortedDirList {
	private File path;
	private String[] list;
	
	/**
	 * 构造函数，需要传进来一个 String 
	 * @param afn
	 */
	public SortedDirList(final String afn) {
		path = new File(".");
		if (afn == null)
			list = path.list();
		else
			list = path.list(
					new FilenameFilter() {
						public boolean accept(File dir, String n) {
								String f = new File(n).getName();
								return f.indexOf(afn) != -1;
							}
					});
		sort();
	}
	
	private void print() {
		for(int i = 0; i < list.length; i++)
			System.out.println(list[i]);
	}
	
	private void sort() {
		StrSortVector sv = new StrSortVector();
		for(int i = 0; i < list.length; i++)
			sv.addElement(list[i]);
			// The first time an element is pulled from
			// the StrSortVector the list is sorted:
		for(int i = 0; i < list.length; i++)
			list[i] = sv.elementAt(i);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		SortedDirList sd;
		if(args.length == 0)
			sd = new SortedDirList(null);
		else
			sd = new SortedDirList(args[0]);
		sd.print();
	}

}
