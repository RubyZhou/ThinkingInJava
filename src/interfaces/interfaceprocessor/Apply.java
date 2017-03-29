package interfaces.interfaceprocessor;
/**
 * 内容	：
 * 说明	：Apply 做两件事情, 只是起到了一个组合作用
 * 		1） 调用name()方法， 将 processor 实例的类名输出
 * 		2） 创建一个  继承 processor 接口的类的实例(可以是任何满足改接口的类)，并导入参数 s 调用process
 * 作者	：zhouyf
 * 日期	：2017年3月29日	下午10:57:17
 * 
 */
import static util.Print.*;


public class Apply {
    public static void process(Processor p, Object s) {
	print("Using Processor " + p.name());
	print(p.process(s));
    }

}
