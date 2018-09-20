package 第四版_第十三章_字符串;



import java.util.*;

public class InfiniteRecursion {
    public String toString() {
        return " InfiniteRecursion address"  ;
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();

        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);

    }
}
