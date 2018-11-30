package 第四版_第十四章_类型信息.packageAccess;


import 第四版_第十四章_类型信息.interfaceA.A;

import static 第四版_源码_util.Print.print;


/**
 *  严格控制的接口实现 : 通过包访问控制, 让外部通过 HiddenC 来生成 A 接口时（class C的实现）, 无法调用 A 接口外的任何方法。
 */
// class C 不是 public 的, 所以包外的类无法访问
class C implements A {
    public void     f() { print("public     C.f();");   }
    public void     g() { print("public     C.g()");    }

    void            u() { print("package    C.u()");    }
    protected void  v() { print("pretected  C.v()");    }
    private void    w() { print("private    C.w()");    }

}

public class HiddenC {
    public static A makeA() {
        return new C();
    }
}
