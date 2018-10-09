package 第四版_第十三章_字符串;

import java.io.*;

/**
 *  正则表达式 和 JAVAIO : 扫描输入 （JAVA_SE 1.4 版本，后续会介绍 1.5 中的 Scanner 类方法）
 */
public class SimpleRead {
    public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));

    public static void main(String[] args) {
        try {

            System.out.println("What's your name?");
            String name = input.readLine();

            System.out.println("How old are you? What is your favorite double?");
            System.out.println("input: <age> <double>");
            String number = input.readLine();
            String[] numArray = number.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.format("Hi %s.\n", name);
            System.out.format("In 5 years you will be %s.\n", age + 5);
            System.out.format("My favorite double is %f.\n", favorite / 2);

        } catch (IOException e) {
            System.err.println("I/O Exception.");
        }
    }
}
