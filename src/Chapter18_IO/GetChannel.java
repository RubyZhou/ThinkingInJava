package Chapter18_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从流中产生通道
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {

        // 写文件
        FileChannel fc = new FileOutputStream("src\\Chapter18_IO\\NewIOdata.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        // 文件末尾追加
        fc = new RandomAccessFile("src\\Chapter18_IO\\NewIOdata.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more ".getBytes()));
        fc.close();

        // 读取文件
        fc = new FileInputStream("src\\Chapter18_IO\\NewIOdata.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            System.out.println((char) buff.get());
    }
}
