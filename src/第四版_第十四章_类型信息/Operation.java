package 第四版_第十四章_类型信息;

/**
 *  Subject : 使用 DynamicProxy 自动创建空对象 (涉及命令模式)
 *      Operation 接口
 */
public interface    Operation {
    String  description();
    void    command();
}
