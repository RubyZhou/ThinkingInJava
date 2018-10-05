package 第四版_第十三章_字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static 第四版_源码_util.Print.print;

/**
 * Pattern and Matcher ：正则匹配
 * 输入参数 : abcabcabcdefabc abc+ (abc)+ (abc){2,}
 */
public class TestRegularExpression {
    public static void main(String[] args) {
        if (args.length < 2) {
            print("Usage:\njava TestRegularExpression " + "characterSequence regularExpression+");
            System.exit(0);
        }
        print("Input : \"" + args[0] + "\"");
        for (String arg : args) {
            print("---------------------------------------------");
            print("Regular expression : \"" + arg + "\"");
            print("---------------------------------------------");
            Pattern p = Pattern.compile(arg);   //正则表达式
            Matcher m = p.matcher(args[0]);     //所要匹配的字符串
            while(m.find()) {
                print("Match \"" + m.group() + "\" at Positions " + m.start() + "-" + (m.end() - 1));
            }
        }
    }
}
