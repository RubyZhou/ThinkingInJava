package 第四版_第十三章_字符串;

import 第四版_源码_util.BinaryFile;

import java.io.File;

/**
 * format 应用 : 十六进制转储工具 (二进制方式读取文件, 再用format输出)
 */
public class Hex {

    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;

        for (byte b : data) {
            if (n % 16 == 0)    result.append(String.format("%05X ", n));
            result.append(String.format("%02X", n));
            n++;
            if (n % 16 == 0)    result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws Exception{
        if (args.length == 0)
            System.out.println(format(BinaryFile.read("src\\第四版_第十三章_字符串\\Hex.java")));
        else
            System.out.println(format(BinaryFile.read(new File(args[0]))));
    }
}