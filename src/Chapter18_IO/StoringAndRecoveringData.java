package Chapter18_IO;


import java.io.*;

/**
 * 存储和恢复数据 ：保证在任何平台上读写出来的结果是一致的。
 */
public class StoringAndRecoveringData {

    static String file = "src\\Chapter18_IO\\Data.txt";

    public static void main(String[] args) throws IOException {
        // 定义 OutputStream : 面向字符
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(file))
        );

        out.writeDouble(3.14159);
        out.writeUTF("That was pai");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");

        out.close();

        // 定义 InputStream
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        );

        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

    }
}
