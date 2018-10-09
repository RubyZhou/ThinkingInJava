package 第四版_第十三章_字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  正则表达式 : 使用 reset()
 */
public class Resetting {
    public static void main(String[] args) throws Exception{
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");

        while (m.find()) {
            System.out.println(m.group() + " ");
        }
        System.out.println();
        m.reset("fix the rig with rags");
        while (m.find())
            System.out.println(m.group() + " ");
    }
}
