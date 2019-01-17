package Chapter18_IO;

import java.io.*;


/**
 *  基本文件的输出 ( Reader -> Writer)
 */
public class BasicFileOutput {

    static String file = "src\\Chapter18_IO\\BasicFileOut.out";

    public static void main(String[] args) throws IOException {
        // 定义 Reader
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("src\\Chapter18_IO\\BasicFileOutput.java")
                )
        );
        // 定义 Writer ：FileWriter 装饰成 PrintWriter
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)
                )
        );

        int lineCount = 1;  // 打印行号用
        String  s;

        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);

        // 如果不关闭, 缓冲区不会刷新清空
        out.close();

        System.out.println(BufferedInputFile.read(file));
    }
}
