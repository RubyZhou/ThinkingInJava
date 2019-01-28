package Chapter18_IO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 *  对 CharBuffer 中的字符进行 scramble 和 unscramble
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
    }
}
