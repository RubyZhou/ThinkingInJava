package Chapter18_IO;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 *  文本文件输出的快捷方式 (PrintWriter)
 */
public class FileOutputShortcut {
    static String file = "src\\Chapter18_IO\\FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        // 定义 Reader
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("src\\Chapter18_IO\\FileOutputShortcut.java")));
        // 定义 Writer
        //  >> SE5之后 PrintWriter 可直接传入 file, 无需装饰.
        //  >> 即: new PrintWriter(file) 代替 new PrintWriter(new BufferedWriter(new FileWriter(file)))
        PrintWriter out = new PrintWriter(file);

        int lineCount = 1;
        String s;

        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);

        out.close();

        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}
