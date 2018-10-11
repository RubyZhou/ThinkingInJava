package 第四版_第十四章_类型信息;


import static 第四版_源码_util.Print.print;

/**
 *  类型信息 : Class 对象，类加载器。
 *      所有对象都是 Class 的一个静态成员, 在第一次使用时加载。
 */

class Candy {
    static  { print("Loading Candy"); }
}

class Gum {
    static { print("Loading Gum"); }
}

class Cookie {
    static { print("Loading Cookie"); }
}


public class SweetShop {
    public static void main(String[] args) {

        print("inside main");
        new Candy();

        print("After creating Candy");
        try {
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            print("Could't find Gum");
        }

        print("After Class.forName(\"GUM\")");

        new Cookie();
        print("After creating Cookie");
    }
}
