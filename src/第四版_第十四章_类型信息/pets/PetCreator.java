package 第四版_第十四章_类型信息.pets;

import java.util.*;

/**
 *  抽象类【接口】 : 生成一个已填充的 Pet 数组 / 链表
 */
public abstract class PetCreator {

    private Random rand = new Random(47);

    /**
     * 抽象类 :
     *          通过 types() 返回一个 List
     * @return
     */
    public abstract List<Class<? extends Pet>> types();

    /**
     * randomPet() :
     *                  随机生成一个 Pet
     * @return
     */
    public Pet randomPet() {
        int n = rand.nextInt(types().size());

        try {
            return types().get(n).newInstance();
        }
        catch (InstantiationException e) { throw new RuntimeException(e); }
        catch (IllegalAccessException e) { throw new RuntimeException(e); }
    }

    /**
     *  createArray(size) :
     *                      创建一个给定大小的 Pet[] 数组，并随机填充
     * @param size
     * @return
     */
    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    /**
     *  arrayList(size) :
     *                      创建一个 Pet 链表
     * @param size
     * @return
     */
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}

