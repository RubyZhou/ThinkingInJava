package 第四版_第十四章_类型信息.pets;


import 第四版_第十章_内部类.Destination;

import java.util.*;

/**
 *  使用字面常量
 *  Function : 用于随机生成一个 list<Pet>
 */
public class LiteralPetCreator extends PetCreator {

    /**
     *  变量 allTypes  的说明 :
     *      1. 功能 :
     *              预加载所有的 class
     *      2. 这是一个 List :
     *              定义了一个 static 并且 final 的 List 型(List中元素只能是 Pet 的子类)
     *      3. unmodifiableList 说明 :
     *              Collections.unmodifiableList(List<? extends T> list)) : 表示将参数中的 list 设置成不可修改的 list
     */
    @SuppressWarnings("unchecked")  // No try block needed.
    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class,
                    Dog.class,
                    Cat.class,
                    Rodent.class,
                    Mutt.class,
                    Pug.class,
                    EgyptianMau.class,
                    Manx.class,
                    Cymric.class,
                    Rat.class,
                    Mouse.class,
                    Hamster.class));

    // Types for random creation:
    /**
     *  types 变量 : 用于随机 Pet 的生成
     *      (1) List.sublist : subList(int start, int end) 获取一个 List 的子集
     */
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}

