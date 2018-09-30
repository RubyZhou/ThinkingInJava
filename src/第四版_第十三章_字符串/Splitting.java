package 第四版_第十三章_字符串;

import java.util.Arrays;

/**
 * 使用 String.split() 方法按正则表达式切割
 */
public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }
    public static void main(String[] args) {
        split(" ");     // Doesn’t have to contain regex chars
        split("\\W+");  // Non-word characters
        split("n\\W+"); // ‘n’ followed by non-word characters
    }
}
