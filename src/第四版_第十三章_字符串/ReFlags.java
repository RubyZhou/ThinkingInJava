package 第四版_第十三章_字符串;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  正则表达式 : 使用 flag
 *      CASE_INSENSITIVE 大小写不敏感
 *      MULTILINE 多行模式，识别 ^ $表示一行的开始和结束
 */
public class ReFlags {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

        Matcher m = p.matcher("java has regex\nJava has regex\n" +
            "JAVA has pretty good regular expressions\n" +
            "Regular expressions are in Java");

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
/* Output:
java
Java
JAVA
*///:~

