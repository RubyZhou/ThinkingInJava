package 第四版_第十四章_类型信息;


import 第四版_辅助类.Dog;

/**
 *  Class类 : cast() 即强制类型转换
 */
class Building {}
class House extends Building {}


public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);

        h = (House)b;


    }
}


