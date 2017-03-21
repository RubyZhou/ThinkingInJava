package interfaces.filters;
/**
 * 内容	：
 * 说明	：
 * 作者	：zhouyf
 * 日期	：2017年3月21日	下午8:50:45
 * 
 */

public class LowPass extends Filter{
    double cutoff;
    public LowPass(double cutoff) {
	// 子类特有的方法
	this.cutoff = cutoff;
    }
    public Waveform process(Waveform input) {
	return input;
    }
}
