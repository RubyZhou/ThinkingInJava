package 第四版_第十三章_字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static 第四版_源码_util.Print.print;
import static 第四版_源码_util.Print.printnb;

/**
 * 正则表达式 : 通过 Matcher.find() 查找多个匹配
 */
public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
        while (m.find()) {
            printnb(m.group() + " ");
        }
        print();

        int i = 0;
        while (m.find(i)) {
            print("[" + i + "] : " + m.group() + " ");
            i++;
        }
    }
}
