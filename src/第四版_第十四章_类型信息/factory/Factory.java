package 第四版_第十四章_类型信息.factory;


/**
 *  Factory 接口功能 :
 *      (1) 输入                 : 接受任意类型 T
 *      (2) 工厂方法, 即 create() : T 必须实现 create(), 并且返回 create() 之后的 T
 *
 * @param <T>
 */
public interface Factory<T> {
    T create();
}
