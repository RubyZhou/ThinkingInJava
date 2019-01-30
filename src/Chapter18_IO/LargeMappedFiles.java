package Chapter18_IO;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static Fourth_util.Print.printnb;

/**
 *  内存映射文件
 */
public class LargeMappedFiles {
    static int length = 0x8FFFFFF;  // 文件大小 : 128 MB, 只访问文件的一小部分

    public static void main(String[] args) throws Exception {
        // 使用 RandomAccessFile for 可读写
        MappedByteBuffer out =
                new RandomAccessFile("src\\Chapter18_IO\\test.dat", "rw").getChannel()
                        .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte)'x');
        }
        System.out.println("Finished writing");
        for (int i = length/2; i < length/2 + 6; i++) {
            printnb((char)out.get(i));
        }
    }
}
