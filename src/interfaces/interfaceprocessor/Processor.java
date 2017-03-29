package interfaces.interfaceprocessor;
/**
 * 内容	：接口型的 Processor
 * 说明	：
 * 作者	：zhouyf
 * 日期	：2017年3月29日	下午10:42:23
 * 
 */

public interface Processor {
    String name();
    Object process(Object input);
}