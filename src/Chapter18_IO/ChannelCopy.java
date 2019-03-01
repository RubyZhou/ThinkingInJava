package Chapter18_IO;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用 channels 和 buffers 复制文件
 */
public class ChannelCopy {
    private static final int SIZE = 1024;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("arguments : sourcefile destfile");
            System.exit(1);
        }

        // 定义输入输出通道
        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();

        // 定义缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(SIZE);

        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }
}

