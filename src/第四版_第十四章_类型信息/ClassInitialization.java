package 第四版_第十四章_类型信息;


import java.util.Random;

/**
 *  类型信息 : 类的字面常量
 */

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}


public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception{
        Class initable = Initable.class;                // Does not trigger initialization:
        System.out.println(">>> After creating Initable Initable ref");     // ref means ：references
        System.out.println(Initable.staticFinal);       // Does trigger initialization:
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);   // Does trigger initialization:

        Class initable3 = Class.forName("第四版_第十四章_类型信息.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);


    }
}
