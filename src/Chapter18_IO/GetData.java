package Chapter18_IO;


import java.nio.ByteBuffer;

import static Fourth_util.Print.print;
import static Fourth_util.Print.printnb;

/**
 * 在 Buffer 中操作基本类型
 */
public class GetData {
    private static final int SIZE = 1024;

    public static void main(String[] args) {

        ByteBuffer bb = ByteBuffer.allocate(SIZE);

        // 一次 get 一个字节
        int i = 0;
        while (i++ < bb.limit()) {
            if (bb.get() != 0)
                print("nonzero");
        }
        print("i = " + i);

        // get 基本数据类型
        bb.rewind();
        System.out.println("Store and read a char array:");
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0)
            printnb(c + " ");
        print();
        bb.rewind();

        System.out.println("Store and read a short:");
        bb.asShortBuffer().put((short) 471142);
        print(bb.getShort());
        bb.rewind();

        System.out.println("Store and read an int:");
        bb.asIntBuffer().put(99471142);
        print(bb.getInt());
        bb.rewind();

        System.out.println("Store and read a long:");
        bb.asLongBuffer().put(99471142);
        print(bb.getLong());
        bb.rewind();

        System.out.println("Store and read a float:");
        bb.asFloatBuffer().put(99471142);
        print(bb.getFloat());
        bb.rewind();

        System.out.println("Store and read a double:");
        bb.asDoubleBuffer().put(99471142);
        print(bb.getDouble());
        bb.rewind();
    }
}
