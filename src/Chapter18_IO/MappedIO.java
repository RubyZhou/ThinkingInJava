package Chapter18_IO;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * I/O流 和 映射 性能比较
 */

public class MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;


    private abstract static class Tester {
        private String name;   // 类名

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.println(name + " : ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }

        public abstract void test() throws IOException;
    }

    // 内部类 Tester 数组
    private static Tester[] tests = {
            new Tester("Stream Write") {    // I/O流 写
                @Override
                public void test() throws IOException {
                    DataOutputStream dos = new DataOutputStream(
                            new BufferedOutputStream(new FileOutputStream(new File("src\\Chapter18_IO\\temp.tmp"))));

                    for (int i = 0; i < numOfInts; i++) {
                        dos.writeDouble(i);
                    }

                    dos.close();
                }
            },
            new Tester("Mapped Write") {    // 映射写
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("src\\Chapter18_IO\\temp.tmp", "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();

                    for (int i = 0; i < numOfInts; i++) {
                        ib.put(i);
                    }
                    fc.close();
                }
            },
            new Tester("Stream Read") {     // I/O流 读
                public void test() throws IOException {
                    DataInputStream dis = new DataInputStream(
                            new BufferedInputStream(new FileInputStream("src\\Chapter18_IO\\temp.tmp")));

                    for (int i = 0; i < numOfInts; i++)
                        dis.readInt();

                    dis.close();
                }
            },
            new Tester("Mapped Read") {     // 映射读
                public void test() throws IOException {
                    FileChannel fc = new FileInputStream(new File("src\\Chapter18_IO\\temp.tmp")).getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();

                    while (ib.hasRemaining())
                        ib.get();

                    fc.close();
                }
            },
            new Tester("Stream Read/Write") {   // I/O流 读写
                public void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(new File("src\\Chapter18_IO\\temp.tmp"), "rw");

                    raf.writeInt(1);

                    for (int i = 0; i < numOfUbuffInts; i++) {
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }

                    raf.close();
                }
            },
            new Tester("Mapped Read/Write") {   // 映射读写
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile(new File("src\\Chapter18_IO\\temp.tmp"), "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();

                    ib.put(0);

                    for (int i = 1; i < numOfUbuffInts; i++)
                        ib.put(ib.get(i - 1));

                    fc.close();
                }
            }
    };

    public static void main(String[] args) {
        for (Tester test : tests)
            test.runTest();
    }
}
