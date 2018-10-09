package 第四版_第十三章_字符串;

import 第四版_源码_util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static 第四版_源码_util.Print.print;

/**
 *  正则表达式 : 替换
 */

/*! Here’s a block of text to use as input to
    the regular expression matcher. Note that we’ll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block. !*/

public class TheReplacements {
    public static void main(String[] args) throws Exception {

        String s = TextFile.read("D:\\workspace\\IDEA\\ThinkingInJava\\src\\第四版_第十三章_字符串\\TheReplacements.java");

        // TODO : 匹配 "/*!" 和 "!* /" 之间的文本
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);

        if (mInput.find()) {
            s = mInput.group(1);
        }
        print("----------------------------------------------------");
        print(s);

        // TODO : 将两个以上的空格缩减为一个
        print("----------------------------------------------------");
        s = s.replaceAll(" {2,}", " ");
        print(s);


        // TODO : 去除每行开头的空格 ; 直接用 String 自带 replaceAll
        //  (?m) : 打开多行状态 && 将 ^ 识别为行开头
        print("----------------------------------------------------");
        s = s.replaceAll("(?m)^ +", "");
        print(s);

        // TODO : 将第一个匹配到的任意 [aeiou] 换成 (VOWEL1)
        print("----------------------------------------------------");
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        print(s);

        // TODO : 将所有 [aeiou] 转成大写
        print("----------------------------------------------------");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while (m.find()) {
            print();
            m.appendReplacement(sbuf, m.group().toUpperCase());
            print(m.group() + " >> " + sbuf);
        }
        // TODO : 将最后的小尾巴 [blOck.] 中的 [ck.] 连到 sbuf 中
        m.appendTail(sbuf);
        print(sbuf);

    }
}
