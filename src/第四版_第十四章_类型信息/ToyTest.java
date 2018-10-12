package 第四版_第十四章_类型信息;


import static 第四版_源码_util.Print.print;

/**
 *  Class 对象 : 基本功能
 */

interface HasBatteries  {}  /* 有电池  */
interface Waterproof    {}  /* 防水   */
interface Shoots        {}  /* 发射   */

class Toy {
    Toy()       {}
    Toy(int i)  {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy()  { super(1); }
}



public class ToyTest {
    static void printInfo(Class cc) {
        print();
        print("Class name: " + cc.getName());
        print("-----------------------------------");
        print("is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name: " + cc.getCanonicalName());

    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("第四版_第十四章_类型信息.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);

        for (Class face :
                c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Cannot access");
            System.exit(1);
        }
        print("=================");
        printInfo(obj.getClass());
    }
}
