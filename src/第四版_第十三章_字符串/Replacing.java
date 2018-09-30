package 第四版_第十三章_字符串;

/**
 * String 自带正则工具3 ： 替换 replaceFirst / replacAll
 */
public class Replacing {

    static String s = Splitting.knights;

    public static void main(String[] args) {
        System.out.println("----------------------------");
        System.out.println(s);
        System.out.println("----------------------------");
        System.out.println(s.replaceFirst("f\\w+", "located")); // 替换（第一个） f 开头的单词
        System.out.println("----------------------------");
        System.out.println(s.replaceAll("shrubbery|tree|herring", "BANANA")); // 将三个单词替换成 BANANA
    }
}
