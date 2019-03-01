package Chapter18_IO;


import java.io.PrintWriter;

/**
 * Turn System.out into a PrintWriter.
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world!");
    }
}
