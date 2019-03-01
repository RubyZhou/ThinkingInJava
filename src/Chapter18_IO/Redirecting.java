package Chapter18_IO;


import java.io.*;

/**
 * 标准I/O 重定向
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {

        // 保存原先的标准输出, 待恢复用
        PrintStream console = System.out;

        // 配置重定向的输入
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("src\\Chapter18_IO\\Redirecting.java")
        );
        // 设置重定向的输出
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("src\\Chapter18_IO\\test.out")
                )
        );
        // 标准 I/O 重定向生效
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        // 将新的 System.in 包装成缓存
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        // 写新的标准输出(文件)
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close();
        System.setOut(console); // 恢复标准输出
    }
}
