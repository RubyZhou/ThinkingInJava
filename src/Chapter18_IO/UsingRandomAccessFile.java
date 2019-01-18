package Chapter18_IO;


import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *  读写随机访问文件（RandomAccessFile）
 */
public class UsingRandomAccessFile {
    static String file = "src\\Chapter18_IO\\rtest.dat";
    static double PAI  = 3.14159;

    static void display() throws IOException {
        //
        RandomAccessFile rf = new RandomAccessFile(file, "r");

        for (int i = 0; i < 7; i++) {
            System.out.println("Value" + i + ": " + rf.readDouble());
        }

        System.out.println(rf.readUTF());
        System.out.println("----------------------------------------------");
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        //
        RandomAccessFile rf = new RandomAccessFile(file, "rw");

        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * PAI);
        }
        rf.writeUTF("The end of the file");
        rf.close();

        display();

        rf = new RandomAccessFile(file, "rw");
        rf.seek(5 * 8);     // double ： 8 字节, 5 * 8 直接定位到第6个数据的起始位置
        rf.writeDouble(47.0001);
        rf.close();

        display();
    }
}
