package Chapter18_IO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 *  操作 Buffer 的四个索引, 对 CharBuffer 中的字符进行 scramble 和 unscramble
 */

public class UsingBuffers {
    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    private static void symmetricScramble1(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            char c3 = buffer.get();
            buffer.reset();
            buffer.put(c3).put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        // 编码
        symmetricScramble(cb);
        System.out.println(cb.rewind());
        // 译码
        symmetricScramble(cb);
        System.out.println(cb.rewind());

        // 练习
        symmetricScramble1(cb);
        System.out.println(cb.rewind());
        symmetricScramble1(cb);
        System.out.println(cb.rewind());
    }
}
