package 第四版_第十四章_类型信息.pets;


import java.util.ArrayList;
import java.util.List;

/**
 *  使用 forName 方式实现抽象类 PetCreator
 */
public class ForNameCreator extends PetCreator{

    // TODO : 定义一个 List, 用 ArrayList 实现
    // Thinking : 面向接口编程
    private static  List<Class<? extends Pet>>  types =
            new ArrayList<Class<? extends Pet>>();

    // Thinking : 将可变的内容分离
    private static String[] typeNames = {
            "第四版_第十四章_类型信息.pets.Mutt",
            "第四版_第十四章_类型信息.pets.Pug",
            "第四版_第十四章_类型信息.pets.EgyptianMau",
            "第四版_第十四章_类型信息.pets.Manx",
            "第四版_第十四章_类型信息.pets.Cymric",
            "第四版_第十四章_类型信息.pets.Rat",
            "第四版_第十四章_类型信息.pets.Mouse",
            "第四版_第十四章_类型信息.pets.Hamster"
    };

    // TODO : 使用 forName 填充 List
    @SuppressWarnings("unchecked")  // 不能置于静态初始化子句上
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add(
                        (Class<? extends Pet>)Class.forName(name)); // 使用
            }
        } catch (ClassNotFoundException e) {    // 因为 try 中的 name 在编译器无法验证
            throw new RuntimeException();
        }
    }

    // TODO : 静态初始化
    static { loader(); }


    // TODO : 实现基类抽象方法，将已填充的 types 返回给外部
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
