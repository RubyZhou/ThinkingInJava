package 第四版_第十三章_字符串;

/**
 * 正则表达式 : n 种姿势匹配 Rudolph
 */
public class Rudolph {
    public static void main(String[] args) {
        for (String pattern : new String[]{"Rudolph", "[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*"})
            System.out.println("Rudolph".matches(pattern));
    }
}
