package Chapter18_IO;


import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 *  将 ByteBuffer 转换成 IntBuffer 视图来使用, 增/改/查 数据
 */
public class IntBufferDemo {
    private static final int SIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer  bb = ByteBuffer.allocate(SIZE);
        IntBuffer   ib = bb.asIntBuffer();

        // 增加 buffer 中数据 : int 数组
        ib.put(new int[] {11, 42, 47, 99, 143, 811, 1016});

        // 查, 改 buffer 数据- 单条
        System.out.println(ib.get(3));
        ib.put(3, 1811);

        System.out.println("--------------------");

        // 全量查 buffer 数据
        ib.flip();

        while(ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }

    }
}
