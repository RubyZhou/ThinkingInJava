package Chapter18_IO;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  文件到缓存后使用 (BufferedReader)
 *  流程 :
 *      1. BufferReader 将 filename 一次性全部读进来
 *      2. 循环读 BufferReader 写入 StringBuilder  (每次从 buffer 中取一行, 比从文件中取快)
 *      3. 关闭文件
 *      4. 将 StringBuilder 输出
 */
public class BufferedInputFile {

    public static String    read(String filename) throws IOException {

        BufferedReader  in = new BufferedReader(new FileReader(filename));
        StringBuilder   sb = new StringBuilder();
        String  s;

        while ((s = in.readLine()) != null) {
            sb.append(s + '\n');    // 注 : readLine 会将换行去掉
        }

        in.close();

        return  sb.toString();
    }

    // 测试 : 直接读本 java 文件
    public static void main(String[] args) throws IOException {
        System.out.println(read("src\\Chapter18_IO\\BufferedInputFile.java"));
    }

}
