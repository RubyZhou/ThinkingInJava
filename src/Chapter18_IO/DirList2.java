package Chapter18_IO;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

/**
 *  显示目录（改进版）：通过匿名内部类【注 : 可以封装在一个方法中】代替单独的类
 */
public class DirList2 {

    public static FilenameFilter filter(final String regex) {
        // anonymous inner class
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File path = new File("D:\\workspace\\IDEA\\ThinkingInJava\\src\\Chapter18_IO");
        String[] list;

        System.out.println("path = [" + path + "]");

        if (args.length == 0) {
            list = path.list();
        }
        else {
            list = path.list(filter(args[0]));
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        for (String dirItem:
             list) {
            System.out.println(dirItem);
        }
    }
}
