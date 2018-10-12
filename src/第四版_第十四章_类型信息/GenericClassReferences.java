package 第四版_第十四章_类型信息;


/**
 *  泛化 Class : 证明泛型对类型严格要求的 Class<Integer> 无法使用 double
 */
public class GenericClassReferences {
    public static void main(String[] args) {

        Class           intClass        = int.class;
        Class<Integer>  genericIntClass = int.class;

        genericIntClass = Integer.class;    // Same thing

        intClass = double.class;
        // genericIntClass = double.class; // Illegal
    }
}
