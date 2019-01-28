package Chapter18_IO;

/**
 *  高位优先 & 低位优先
 */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Endians {
    public static void main(String[] args) {
        // 申请 buffer 的空间, char = 2 byte ; 12 byte 存放 6 个字母
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);

        // ByteBuffer 默认高位优先
        bb.asCharBuffer().put("abcdef");    // 通过 asCharBuffer() 视图将 char Array 装进 byteBuffer
        System.out.println("\nbb defult : \n" + Arrays.toString(bb.array()));

        // 设置高位优先
        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println("\nbb BIG_ENDIAN : \n" + Arrays.toString(bb.array()));

        // 设置低位优先
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println("\nbb LITTLE_ENDIAN : \n" + Arrays.toString(bb.array()));
    }
}
