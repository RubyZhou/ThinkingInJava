package 第四版_第十四章_类型信息;

import Fourth_util.Null;

/**
 *  测试空对象 : Person 类
 */
public class Person {
    public final String     first;
    public final String     last;
    public final String     address;

    public Person(String first, String last, String address) {
        this.first   = first;
        this.last    = last;
        this.address = address;
    }

    public String toString() {
        return "Person : " + first + " " + last + "" + " " + address;
    }

    /**
     *  NullPerson 内部类 : 继承自 Person 实现了 Null 接口
     */
    public static class NullPerson extends Person implements Null {

        private NullPerson() {
            super("None", "None", "None");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }

    /**
     *  静态变量 NULL : 将原本一个需要到处检查的 null 值 Person, 赋值为 NullPerson (初始化时)。后续则不需要判断了
     */
    public static final Person NULL = new NullPerson();
}
