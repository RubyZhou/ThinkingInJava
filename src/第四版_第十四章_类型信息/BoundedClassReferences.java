package 第四版_第十四章_类型信息;


/**
 *  泛化 Class : 带 extends 的通配符 : 对完全放开的类型再稍加限制
 */

public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;

    }
}
