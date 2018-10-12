package 第四版_第十四章_类型信息;


/**
 *  泛化 Class : 通配符 - 放松泛型的类型限制
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
