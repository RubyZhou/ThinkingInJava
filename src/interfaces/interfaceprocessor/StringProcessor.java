package interfaces.interfaceprocessor;
/**
 * 内容	：
 * 说明	：模拟客户端程序员根据借口编写类
 * 作者	：zhouyf
 * 日期	：2017年3月29日	下午11:07:29
 * 
 */
import java.util.*;

public abstract class StringProcessor implements Processor{
    	// 抽象类：必须包含抽象方法		// 继承接口
    public String name() {
	// 对接口中 name()方法 进行实现
	return getClass().getSimpleName();
    }
    
    public abstract String process(Object input);
    	// 将 process 方法的实现设置为抽象方法 ， 由他的子类去进行具体实现

    
    public static String s = 
	    "If she weights the same as a duck, She's made of wood!\n";
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Apply.process(new Upcase(), s);		//Q:为什么这里可以直接调用Apply的process?
	Apply.process(new Downcase(), s);
	Apply.process(new Splitter(), s);
    }
}

class Upcase extends StringProcessor {
    // 覆盖基类中的抽象类, 将传入的字符串转换为大写 并且 return 出去
    public String process(Object input) {
	return ((String)input).toUpperCase();
    }
}

class Downcase extends StringProcessor {
    
    public String process(Object input) {
	return ((String)input).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    
    public String process(Object input) {
	return Arrays.toString( ((String)input).split(" ") );
    }
}











