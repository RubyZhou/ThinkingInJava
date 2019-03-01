package Chapter18_IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;


/**
 * 显示目录（改进版2）：在参数中使用匿名内部类 代替 在方法中使用
 * <p>
 * 优点 : 代码隔离, 内聚
 * 缺点 : 不易阅读
 */
public class DirList3 {
    public static void main(final String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(
                    new FilenameFilter() {
                        Pattern pattern = Pattern.compile(args[0]);

                        @Override
                        public boolean accept(File dir, String name) {
                            return pattern.matcher(name).matches();
                        }
                    }
            );
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}
