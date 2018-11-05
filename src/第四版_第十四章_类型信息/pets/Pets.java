package 第四版_第十四章_类型信息.pets;

import java.util.ArrayList;

/**
 *  Function : 使用了 LiteralPetCreator 实现的外观类
 */

public class Pets {

    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet               randomPet()             {   return creator.randomPet();         }
    public static Pet[]             createArray(int size)   {   return creator.createArray(size);   }
    public static ArrayList<Pet>    arrayList(int size)     {   return creator.arrayList(size);     }
}
