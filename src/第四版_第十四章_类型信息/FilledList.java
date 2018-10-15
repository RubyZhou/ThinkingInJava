package 第四版_第十四章_类型信息;


import java.util.ArrayList;
import java.util.List;

/**
 *  类型信息 : 使用 type.newInstance() 创建对象
 */

// TODO : 定义一个 CountedInteger 的数据类型
class CountedInteger {
    private static  long counter;
    private final   long id = counter++;

    public String toString() {
        return  Long.toString(id);
    }
}

// 插 List 类
public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create (int nElements) {
        List<T> result = new ArrayList<T>();

        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(fl.create(15));
    }
}
