package interfaces.filters;
/**
 * 内容	：
 * 说明	：
 * 作者	：zhouyf
 * 日期	：2017年3月21日	下午8:58:50
 * 
 */

public class BandPass extends Filter {
    double lowCutoff, highCutoff;
    public BandPass(double lowCut, double highCut) {
	lowCutoff = lowCut;
	highCutoff = highCut; 
    }
    public Waveform process(Waveform input) { return input; }

}
