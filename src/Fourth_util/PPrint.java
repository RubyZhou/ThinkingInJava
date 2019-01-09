package Fourth_util;


import java.util.Arrays;
import java.util.Collection;

/**
 *  打印工具 : 可添加新行并缩排所有元素的工具
 */
public class PPrint {

    // pformat() : 从 Collection 中产生 String
    public static String    pformat(Collection<?> c) {
        if (c.size() == 0) { return  "[]";  }

        StringBuilder result = new StringBuilder("[");

        for (Object elem : c) {
            if (c.size() != 1)
                result.append("\n   ");
            result.append(elem);
        }

        result.append("]");
        return  result.toString();
    }

    // pprint() : 使用 pformat() 来执行任务
    public static void  pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void  pprint(Object[] c) {
        System.out.println(pformat(Arrays.asList(c)));
    }
}
