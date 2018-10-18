package 第四版_第十四章_类型信息.pets;

import java.util.*;

/**
 *  辅助类 : 生成一个已填充的 Pet 数组 / 链表
 */
public abstract class PetCreator {

    private Random rand = new Random(47);

    // TODO : 抽象类，通过 types() 返回一个 List
    public abstract List<Class<? extends Pet>> types();

    // TODO : 随机生成一个 Pet
    public Pet randomPet() {
        int n = rand.nextInt(types().size());

        try {
            return types().get(n).newInstance();
        }
        catch (InstantiationException e) { throw new RuntimeException(e); }
        catch (IllegalAccessException e) { throw new RuntimeException(e); }
    }

    // TODO : 创建一个给定大小的 Pet[] 数组，并随机填充
    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    // TODO : 创建一个 Pet 链表
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}

