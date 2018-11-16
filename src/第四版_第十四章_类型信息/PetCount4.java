package 第四版_第十四章_类型信息;

import 第四版_第十四章_类型信息.pets.Pet;
import 第四版_第十四章_类型信息.pets.Pets;

import static 第四版_源码_util.Print.print;
import static 第四版_源码_util.Print.printnb;


/**
 *  使用 TypeCounter 进行递归计数
 */
public class PetCount4 {

    public static void main(String[] args) {

        TypeCounter counter = new TypeCounter(Pet.class);

        for (Pet pet :
                Pets.createArray(20)) {
            printnb(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }

        print();
        print(counter);
    }
}

/*
    其中 : Pet 作为基类计数20次
    Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
    {Pug = 3, Dog = 6, Cat = 9, Rodent = 5, Rat = 2, Mutt = 3, Cymric = 5, Hamster = 1, Pet = 20, Manx = 7, EgyptianMau = 2, Mouse = 2}
 */