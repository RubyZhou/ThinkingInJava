package 第四版_第十三章_字符串;

import 第四版_源码_generics.Coffee;
import 第四版_源码_generics.CoffeeGenerator;

import java.util.ArrayList;


// TODO : 用一个 ArrayList 存多个对象，调用 toString() 显示

public class ArrayListDisplay {
    public static void main(String[] args) {

        ArrayList<Coffee> coffees = new ArrayList<Coffee>();

        for (Coffee c : new CoffeeGenerator(10)) {
            coffees.add(c);
        }

        System.out.println("---------------------------");
        System.out.println(coffees);
        System.out.println("---------------------------");
    }
}
