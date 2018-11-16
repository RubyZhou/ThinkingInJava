package 第四版_第十四章_类型信息;


import java.util.HashMap;
import java.util.Map;

/**
 *  递归计数 : Class.isAssignableFrom( )
 *      use Class.isAssignableFrom( ) and create a general-purpose tool that is not limited to counting Pets
 *      isAssignableFrom() :
 *
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {

    private Class<?>    baseType;

    // Constructor
    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    /**
     * 对外提供的 public 接口 (针对所有 Object)
     * @param obj
     */
    public void count(Object obj) {
        Class<?> type = obj.getClass(); // getClass() ?

        if(!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + " incorrect type : " + type + ", should be type or subtype of " + baseType);
        }
        countClass(type);
    }

    /**
     * 递归计数实现 ( 这里是 private 的 )
     * @param type
     */
    private void countClass(Class<?> type) {
        Integer quantity = get(type);

        put(type, quantity == null ? 1 : quantity + 1);     // 这里的 put 默认是对 TypeCounter 类进行操作的。

        Class<?> superClass = type.getSuperclass();

        if ( superClass != null && baseType.isAssignableFrom(superClass) ) {
            countClass(superClass);     // 递归
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder("{");  // REVIEW [StringBuilder适用场景] : toString() 是由多个字符串组合起来 or 通过循环组合的

        // REVIEW [Map.Entry & entrySet()] :
        //      Map.Entry<K, V>  : Map 中的一对 Key-value
        //      entrySet()       : 返回 Map 中所有 key-value 对的集合
        for (Map.Entry<Class<?>, Integer> pair :    //
                entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append(" = ");
            result.append(pair.getValue());
            result.append(", ");
        }

        result.delete(result.length() - 2, result.length());
        result.append("}");

        return result.toString();
    }
}
