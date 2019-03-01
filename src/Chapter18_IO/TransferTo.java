package Chapter18_IO;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 连接两个通道(transferTo / transferFrom), 进行文件复制
 */
public class TransferTo {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("arguments : sourcefile destfile");
            System.exit(1);
        }
        // 定义输入输出通道
        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();

        in.transferTo(0, in.size(), out);
        // OR :
        // out.transferFrom(in, 0, in.size());
    }
}
