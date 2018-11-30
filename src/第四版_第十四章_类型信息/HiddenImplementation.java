package 第四版_第十四章_类型信息;


import 第四版_第十四章_类型信息.interfaceA.A;
//!import 第四版_第十四章_类型信息.packageAccess.C;
import 第四版_第十四章_类型信息.packageAccess.HiddenC;

import java.lang.reflect.Method;

/**
 *  HiddenC 的测试类 :
 *      private 的后门 : 通过反射机制曲线救国, 调用到隐藏方法( private 也能调用到 ), 前提是知道方法名
 */
public class HiddenImplementation {

    public static void main(String[] args) throws Exception{

        A a = HiddenC.makeA();
        a.f();
        /**
         *  虽然无法 new C(), 但可以知道到底谁实现了 A 接口!
         *      >>> 第四版_第十四章_类型信息.packageAccess.C
         */
        System.out.println("a.getClass().getName() = " + a.getClass().getName());

        /*  包外的类无法调用 class C
        if(a instanceof C) {
            C c = (C)a;
            c.g();
        }
        */
        //! A a = new C(); // 同样无法new C()

        // 通过反射机制调用隐藏方法( 甚至 private ) :
        //      尽管无法直接调用 C 中不在接口 A 中的方法, 用类型信息反射绕道, 仍然可以调用到隐藏的方法
        System.out.println("--------------------------------");
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    /**
     *  统一调用隐藏方法
     */
    static void callHiddenMethod(Object a, String methodName) throws Exception{
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
