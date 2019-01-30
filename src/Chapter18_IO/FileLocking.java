package Chapter18_IO;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 *  文件加锁
 */
public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("src\\Chapter18_IO\\file.txt");
        FileLock fileLock = fos.getChannel().tryLock();

        if (fileLock != null) {
            System.out.println("File Locked!");
            TimeUnit.MILLISECONDS.sleep(100);
            fileLock.release();
            System.out.println("Release Lock");
        }

        fos.close();
    }
}
