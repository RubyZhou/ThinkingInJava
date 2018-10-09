package 第四版_第十三章_字符串;

import java.util.Scanner;

/**
 * Scanner : 分隔符的使用
 */
public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        scanner.useDelimiter("\\s*,\\s*");
        while(scanner.hasNextInt())
            System.out.println(scanner.nextInt());
    }
}
