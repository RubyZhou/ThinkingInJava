package Chapter18_IO;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 使用 Bytebuffer.asCharBuffer 一次输出多条数据。(PS : 默认通过 Bytebuffer.get() 是一次读取一个字节)
 */
public class BufferToText {
    private static final int SIZE = 1024;

    public static void main(String[] args) throws Exception {
        /*------------------------------ GROUP I --------------------------------------------*/
        // (1) 写文件
        FileChannel fc = new FileOutputStream("src\\Chapter18_IO\\NewIOdata2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        // (2) 写完之后进行读取
        fc = new FileInputStream("src\\Chapter18_IO\\NewIOdata2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(SIZE);
        fc.read(buff);
        buff.flip();

        // Doesn’t work : 会乱码
        System.out.println("Print buff : " + buff.asCharBuffer());
        // Decode using this system’s default Charset:
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + " : " + Charset.forName(encoding).decode(buff));

        /*------------------------------ GROUP II -------------------------------------------*/
        System.out.println("\n>>> After write(encoding) ");

        // (3) 按指定编码重新写文件
        fc = new FileOutputStream("src\\Chapter18_IO\\NewIOdata2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();

        // (4) 再次读取不会乱码
        fc = new FileInputStream("src\\Chapter18_IO\\NewIOdata2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println("Print buff again: " + buff.asCharBuffer());


        /*------------------------------ GROUP III ------------------------------------------*/
        System.out.println("\n>>> After write(buff.put) ");

        fc = new FileOutputStream("src\\Chapter18_IO\\NewIOdata2.txt").getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text ");  // 这里就是通过缓冲区, 直接写
        fc.write(buff);
        fc.close();

        fc = new FileInputStream("src\\Chapter18_IO\\NewIOdata2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println("Print buff again: " + buff.asCharBuffer());
    }
}
