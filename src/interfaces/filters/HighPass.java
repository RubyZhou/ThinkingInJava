package interfaces.filters;
/**
 * 内容	：
 * 说明	：
 * 作者	：zhouyf
 * 日期	：2017年3月21日	下午8:53:32
 * 
 */

public class HighPass extends Filter {
    double cutoff; 
    
    /* cutoff  
    n.	近路; 运河; 新河道; 中止;
    */
    
    public HighPass(double cutoff) {
	this.cutoff = cutoff;
    }
    
    public Waveform process(Waveform input) {
	// 覆盖基类的方法，但感觉和基类的该方法是一模一样的
	return input;
    }
    	
}
