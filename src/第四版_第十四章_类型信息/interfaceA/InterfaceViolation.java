package 第四版_第十四章_类型信息.interfaceA;


import static 第四版_源码_util.Print.print;

/**
 *  非理想状态的接口实现 :
 */
class B implements A {
    public void     f() {}
    public void     g() { print("This is Class_B.g()!"); }
}

public class InterfaceViolation {

    public static void main(String[] args) {
        A a = new B();
        a.f();
        /**
         *  Compile error :
         *      接口 A 虽然用 B 实现的, 但实际不包含 g() 方法, 无法调用 -> key : 以接口方式进行解耦
         */
        //! a.g() :
        System.out.println("a.getClass().getName() = " + a.getClass().getName());

        if (a instanceof B) {
            B b = (B)a;
            b.g();
        }
    }
}
