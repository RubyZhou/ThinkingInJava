package Chapter18_IO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * 格式化的内存输入 : 转换成字节流
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in =
                    new DataInputStream(
                            new ByteArrayInputStream(
                                    BufferedInputFile.read("src\\Chapter18_IO\\FormattedMemoryInput.java").getBytes()));
            while (true)
                System.out.print((char) in.readByte());
        }
        catch (EOFException e) {
            System.err.println("End of stream.");
        }
    }
}
