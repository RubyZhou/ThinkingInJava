//: generics/coffee/Coffee.java
package 第四版_源码_generics;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
} ///:~
