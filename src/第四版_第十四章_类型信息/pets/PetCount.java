package 第四版_第十四章_类型信息.pets;


import java.util.HashMap;

import static 第四版_源码_util.Print.print;
import static 第四版_源码_util.Print.printnb;

/**
 *  给 Pet 进行计数 :
 *      instanceof 关键字 : 判断对象是否是某个类型的实例
 */
public class PetCount {

    /**
     *  内部类, 自定义一个 "Map系列" 的数据类型.
     */
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {

            Integer quantity = get(type);

            if (quantity == null)   // get 不到则, 初始化数量为 1
                put(type, 1);
            else                    // get 到，递增
                put(type, quantity + 1);
        }
    }

    /**
     *   countPets() : 逐个计数
     *          需要一个 PetCreator 生成器
     */
    public static void countPets(PetCreator creator) {

        PetCounter counter = new PetCounter();

        for (Pet pet : creator.createArray(20)) {

            // List each individual pet:
            printnb(pet.getClass().getSimpleName() + " ");

            // 通用的 pet
            if(pet instanceof Pet)                counter.count("Pet");
            if(pet instanceof Dog)                counter.count("Dog");
            if(pet instanceof Mutt)               counter.count("Mutt");
            if(pet instanceof Pug)                counter.count("Pug");
            if(pet instanceof Cat)                counter.count("Cat");
            if(pet instanceof Manx)               counter.count("EgyptianMau");
            if(pet instanceof Manx)               counter.count("Manx");
            if(pet instanceof Manx)               counter.count("Cymric");
            if(pet instanceof Rodent)             counter.count("Rodent");
            if(pet instanceof Rat)                counter.count("Rat");
            if(pet instanceof Mouse)              counter.count("Mouse");
            if(pet instanceof Hamster)            counter.count("Hamster");
        }

        // Show the counts:
        print();
        print(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }

}
