package 第四版_第十三章_字符串;

// A very simple version of the "grep" program.
// {Args: dict.txt "\\b[Ssct]\\w+"}

import 第四版_源码_util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  正则表达式 : 模仿 grep 进行匹配文件
 */
public class JGrep {
    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
// Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        for(String line : new TextFile(args[0])) {
            m.reset(line);
            while(m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        }
    }
}
