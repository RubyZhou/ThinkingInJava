package 第四版_第十四章_类型信息;


/**
 *  Class 类 : 用 newInstance() 创建明确对象类型 及 创建模糊的基类类型 (Object)
 */
public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        // TODO : 通过 类型.class.newInstance() 创建一个对象 （具体类型）
            Class<FancyToy> ftClass = FancyToy.class;
        // Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();

        // TODO : 进一步，创建出他的基类对象 （非具体类型）
        Class<? super FancyToy> up = ftClass.getSuperclass();
        // This won’t compile:
        // Class<Toy> up2 = ftClass.getSuperclass();
        // Only produces Object:
        Object obj = up.newInstance();
    }
}
