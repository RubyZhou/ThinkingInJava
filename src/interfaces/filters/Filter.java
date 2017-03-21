package interfaces.filters;
/**
 * 内容	：
 * 说明	：
 * 作者	：zhouyf
 * 日期	：2017年3月21日	下午8:48:07
 * 
 */

public class Filter {
    // n. 滤波器
    public String name() {
	return getClass().getSimpleName();
    }
    public Waveform process(Waveform input) {
	// 组合了Waveform
	return input;
    }
}
