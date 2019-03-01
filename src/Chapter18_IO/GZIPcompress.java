package Chapter18_IO;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 使用 GZIP 进行压缩
 */
public class GZIPcompress {
    public static void main(String[] args) throws IOException {

        // 输入项检查
        if (args.length == 0) {
            System.out.println("Usage : \nGZIPcompress file\n" + "\tUses GZIP compression to compress " + "the file to test.gz");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("src\\Chapter18_IO\\test.gz")));

        // 写压缩文件
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();

        // 读压缩文件
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("src\\Chapter18_IO\\test.gz"))));
        String s;
        while ((s = in2.readLine()) != null) {
            System.out.println(s);
        }
    }
}
