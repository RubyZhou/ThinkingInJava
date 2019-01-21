package Chapter18_IO;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  从 System.in 读取数据
 */
public class Echo {

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String s;

        while ( null != (s = stdin.readLine()) && 0 != s.length() ) {
            System.out.println(s);
        }
    }
}
