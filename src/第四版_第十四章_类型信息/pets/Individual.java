package 第四版_第十四章_类型信息.pets;


/**
 *  Function       : 创建具名和不具名的对象
 *      id()       : 返回唯一标识
 *      toString() : 不具名的 Individual 只产生类型名
 */
public class Individual implements Comparable<Individual> {

    private static  long    counter = 0;
    private final   long    id      = counter++;
    private         String  name;

    // 'name' is optional:
    public Individual()             {}
    public Individual(String name)  { this.name = name; }

    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

    public long id() { return id; }

    public boolean equals(Object o) {
        return o instanceof Individual && id == ((Individual)o).id;
    }

    public int hashCode() {
        int result = 17;
        if(name != null)
            result = 37 * result + name.hashCode();
        result = 37 * result + (int)id;
        return result;
    }

    public int compareTo(Individual arg) {
        // Compare by class name first:
        String  first           = getClass().getSimpleName();
        String  argFirst        = arg.getClass().getSimpleName();
        int     firstCompare    = first.compareTo(argFirst);

        if(firstCompare != 0)
            return firstCompare;

        if(name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);

            if(secondCompare != 0)
                return secondCompare;
        }

        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}