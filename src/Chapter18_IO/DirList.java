package Chapter18_IO;

import java.util.regex.*;
import java.io.*;
import java.util.*;

/**
 * Funtion : 遍历目录的文件名
 * input   : (*)正则表达式
 * args >> .*java - 用于匹配目录下所有 java 文件
 * Info :
 * <1> 策略模式
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File("D:\\workspace\\IDEA\\ThinkingInJava\\src\\第四版_第十三章_字符串");
        String[] list;

        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem :
                list) {
            System.out.println(dirItem);
        }
    }
}

/**
 * 目录过滤器
 */
class DirFilter implements FilenameFilter { // FilenameFilter 提供策略供, 完善 list() 提供服务时所需的算法
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) { // 回调函数 ：accept() 并非被 DirFilter 调用, 而是通过 list(). 在满足 list() 特定场景下触发
        return pattern.matcher(name).matches();
    }
}


