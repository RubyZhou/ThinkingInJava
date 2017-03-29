package interfaces.classprocessor;
/**
 * 内容	：9.3-完全解耦
 * 说明	：设计模式->策略模式
 * 作者	：zhouyf
 * 日期	：2017.3.21
 * 
 */
import java.util.*;
import static util.Print.*;

class Processor {
    public String name() {
	//有一个name 方法获取类名
	return getClass().getSimpleName();
    }
    Object process(Object input) { return input; }
    //Object类是所有类的父类，当不确定传入的类型时，作为一个笼统的类, 该类有通用的方法。如：toUpperCase...
}

class Upcase extends Processor {
    String process(Object input) {	// Covariant return 覆盖基类方法
	return ((String)input).toUpperCase();	//转换成大写
    }
}
class Downcase extends Processor {
    String process(Object input) {
	return ((String)input).toLowerCase();	//转换成小写
    }
}

class Splitter extends Processor {
    String process(Object input) {
	return Arrays.toString(((String)input).split(" ")); 
		// split 方法将调用他的 String 对象根据参数边界切分成一个个小字符串，返回出 一个 String[] 数组
						
    }
}

public class Apply {
    
    public static void process(Processor p, Object s) {
				//基类p 作为通用的接口
	print("Using Processor " + p.name()); //调用 Processor 输入类名 getclass.getSimpleName()
	print(p.process(s) + "\n");
    }
    
    public static String s = 
	    "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	process(new Upcase(), s);
	process(new Downcase(), s);
	process(new Splitter(), s);
    }

}
