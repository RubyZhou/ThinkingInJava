package 第四版_第十三章_字符串;

import java.util.regex.*;
import java.util.*;

import static 第四版_源码_util.Print.print;


/**
 *  正则表达式 : 使用 split()
 */
public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        print(Arrays.toString(Pattern.compile("!!").split(input)));
        print(Arrays.toString(Pattern.compile("!!").split(input, 3)));
    }
}
