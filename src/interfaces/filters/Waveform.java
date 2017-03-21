package interfaces.filters;
/**
 * 内容	：应用策略模式
 * 说明	：
 * 作者	：zhouyf
 * 日期	：2017年3月21日	下午8:44:48
 * 
 */

public class Waveform {
    	// Waveform 对外提供一个功能：输出 id
    private static long counter;
    private final long id = counter++;
    
    public String toString() {
	// 作为字符串来用
	return "Waveform " + id;
    }
   

}
