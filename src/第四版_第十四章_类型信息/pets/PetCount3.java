package 第四版_第十四章_类型信息.pets;


import 第四版_源码_util.MapData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static 第四版_源码_util.Print.print;
import static 第四版_源码_util.Print.printnb;

/**
 *  isInstance() : A dynamic(动态的) instanceof
 *      vs.PetCount : 通过 Class.instanceof 减少 PetCount 中大量的 "pet instanceof Pet"
 */
public class PetCount3 {

    /**
     *  Inner Class : PetCounter
     *  Tips :
     *      LinkedHashMap : 按插入顺序保存, 并且保持了 HashMap 的查询速度
     */
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {

        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes, 0));
        }

        /**
         *  Function : 对 pet 进行计数
         *  Tips     : Map.Entry
         *          表示 Map 中的一个实体 (一对 key-value). 是 Map 声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。
         * @param pet
         */
        public void count(Pet pet) {
            // entrySet() : 取所有 Map 对;      Map.Entry<K, V> : 取其中一对
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                if (pair.getKey().isInstance(pet))
                    put(pair.getKey(), pair.getValue() + 1);
            }
        }

        public String toString() {
            StringBuilder result = new StringBuilder("{");

            for (Map.Entry<Class<? extends Pet>, Integer> pair
                    : entrySet()) {
                result.append(pair.getKey().getSimpleName());
                result.append(" = ");
                result.append(pair.getValue());
                result.append(",");
            }
            result.delete(result.length() - 2, result.length());    // 去除末尾的","
            result.append("}");
            return result.toString();
        }

        public static void main(String[] args) {
            PetCounter petCount = new PetCounter();

            for (Pet pet :
                    Pets.createArray(20)) {
                printnb(pet.getClass().getSimpleName() + " ");
                petCount.count(pet);
            }

            print();
            print(petCount);
        }

    }
}
