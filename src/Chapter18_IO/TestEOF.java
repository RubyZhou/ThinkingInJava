package Chapter18_IO;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *  一次一个字节读文件 : 每个字节都是合法的, 不会返回错误. 通过 DataInputStream.available() 判断读取到的字节数来作为结束的依据.
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("src\\Chapter18_IO\\TestEOF.java")
                ));

        while (in.available() != 0)
            System.out.println((char) in.readByte());
    }
}
