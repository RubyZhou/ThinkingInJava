package 第四版_第十三章_字符串;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static 第四版_源码_util.Print.print;
import static 第四版_源码_util.Print.printnb;

/**
 *  正则表达式 : 分组
 *   (1) 捕获每行最后三个单词
 *   (2) \S+  : 任意非空格
 *   (3) (?m) : 模式标记, 显示地告知正则表达式 "注意换行符"
 */
public class Groups {

    static private final String POEM =
        "Twas brillig, and the slithy toves\n" +
        "Did gyre and gimble in the wabe.\n" +
        "All mimsy were the borogoves,\n" +
        "And the mome raths outgrabe.\n\n" +
        "Beware the Jabberwock, my son,\n" +
        "The jaws that bite, the claws that catch.\n" +
        "Beware the Jubjub bird, and shun\n" +
        "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);

        while (m.find()) {

            for (int j = 0; j <= m.groupCount(); j++) {
                printnb("[" + m.group() + "]");
                printnb("[" + j + "] : [" + m.group(j) + "]");
                print();
            }
        }
    }
}

