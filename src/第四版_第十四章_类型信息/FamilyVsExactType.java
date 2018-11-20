package 第四版_第十四章_类型信息;

import static 第四版_源码_util.Print.print;
import static 第四版_源码_util.Print.printf;

/**
 *  instanceof 与 Class 的等价性
 */

class Base                  {}
class Derived extends Base  {}  // 派生



public class FamilyVsExactType {
    static void test(Object x) {
        print("----------------------------------------------------");
        print("Testing x of type \"" + x.getClass() + "\"");
        print("----------------------------------------------------");
        print("x instanceof Base           : " + (x instanceof Base));
        print();
        print("Base.isInstance(x)          : " + Base.class.isInstance(x));
        print("Derived.isInstance(x)       : " + Derived.class.isInstance(x));
        print();
        print("x.getClass(x) == Base.class    : " + (x.getClass() == Base.class));
        print("x.getClass(x) == Derived.class : " + (x.getClass() == Derived.class));
        print();
        print("x.getClass().equals(Base.class))    : " + (x.getClass().equals(Base.class)));
        print("x.getClass().equals(Derived.class)) : " + (x.getClass().equals(Derived.class)));

        print("\n\n");
    }

    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}



