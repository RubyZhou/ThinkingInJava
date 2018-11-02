package 第四版_第十四章_类型信息.pets;


import 第四版_第十章_内部类.Destination;

import java.util.*;

/**
 *  使用字面常量
 */
public class LiteralPetCreator extends PetCount {
    // No try block needed.
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
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

}
