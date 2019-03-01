package Chapter18_IO;

import java.io.IOException;
import java.io.StringReader;

/**
 * 文件到内存后使用()
 */
public class MemoryInput {

    public static void main(String[] args) throws IOException {

        StringReader in = new StringReader(BufferedInputFile.read("src\\Chapter18_IO\\MemoryInput.java"));
        int c;

        while ((c = in.read()) != -1) {
            System.out.print((char) c);  // 必须强制转换 : read() 会以int类型返回(ASCII码)
        }
    }
}
