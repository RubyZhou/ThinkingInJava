package 第四版_第十四章_类型信息;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static 第四版_源码_util.Print.print;

/**
 *  Java 的反射机制
 *      命令行参数 : 第四版_第十四章_类型信息.ShowMethods
 */
public class ShowMethods {

    private static String usage =
            "Usage:\n" +
                    "-----------------------------------------\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'\n" +
                    "-----------------------------------------\n" ;

    /**
     *  review ： 正则表达式
     *      (1) \\ : 表示将要插入一个正则表达式
     *      (2) \w : A word character [a-zA-Z_0-9]
     *      (3) w+ : 贪婪型匹配
     *      (4) .  : 单个字符 [.]
     */
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            print(usage);
            System.exit(0);
        }

        int lines = 0;

        try {
            Class<?>    c = Class.forName(args[0]);
            Method[]    methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();

            if (args.length == 1) {
                print("args.length == 1");
                print("------------------------------------------------------------");
                for (Method method : methods)   {
                    //print("method = [" + method + "]");
                    print(p.matcher(method.toString()).replaceAll(""));     // 将成功匹配的全部去除.[java.lang.Object.toString()] => [toString()]
                    //print();
                }
                print("------------------------------------------------------------");
                for (Constructor ctor : ctors)  {
                    print("ctor = [" + ctor + "]");
                    print(p.matcher( ctor.toString() ).replaceAll(""));
                }
                print("------------------------------------------------------------");
                lines = methods.length + ctors.length;
            }
            else {
                print("args.length != 1");

                for (Method method : methods)   {
                    if (method.toString().indexOf(args[1]) != -1)   {
                        print(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }

                for (Constructor ctor : ctors)  {
                    if (ctor.toString().indexOf(args[1]) != -1)     {
                        print(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            print("No such Exception " + e);
        }
    }
}

