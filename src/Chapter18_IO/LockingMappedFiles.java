package Chapter18_IO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 对映射文件部分加锁(多线程)
 */
public class LockingMappedFiles {
    static final int LENGTH = 0x8FFFFFF;    // 128 MB
    static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        fileChannel = new RandomAccessFile("src\\Chapter18_IO\\test.dat", "rw").getChannel();
        MappedByteBuffer out = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            out.put((byte) 'x');
        }

        new LockAndModify(out, 0, 0 + LENGTH / 3);
        new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);


    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buff;
        private int start, end;

        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            buff = mbb.slice();     // 创建一个子缓冲区
            start();
        }

        public void run() {
            try {
                // Exclusive lock with no overlap:
                FileLock fileLock = fileChannel.lock(start, end, false);
                System.out.println("Locked: [" + start + "] to [" + end + "]");

                // Perform modification:
                while (buff.position() < buff.limit() - 1) {
                    buff.put((byte) (buff.get() + 1));
                }

                fileLock.release();
                System.out.println("Release: [" + start + "] to [" + end + "]");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
