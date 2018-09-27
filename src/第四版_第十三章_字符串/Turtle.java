package 第四版_第十三章_字符串;


import java.io.PrintStream;
import java.util.Formatter;

/**
 * Function : 使用 Formatter
 */
public class Turtle {

    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }


    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d, %d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle tommy = new Turtle("tommy", new Formatter(System.out));
        Turtle terry = new Turtle("terry", new Formatter(outAlias));
        tommy.move(0,0);
        terry.move(4,8);
        tommy.move(3,4);
        terry.move(2,5);
        tommy.move(3,3);
        terry.move(3,3);
    }
}
