package interfaces.interfaceprocessor;
/**
 * 内容	：适配器 设计模式
 * 说明	：
 * 作者	：zhouyf
 * 日期	：2017年3月30日	上午12:11:58
 * 
 */
import interfaces.filters.*;

class FilterAdapter implements Processor {
    Filter filter;
    public FilterAdapter(Filter filter) {
	this.filter = filter;
    }
    public String name() { return filter.name(); }
    public Waveform process(Object input) {
	return filter.process((Waveform)input);
    }
}

public class FilterProcessor {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Waveform w = new Waveform();
	Apply.process(new FilterAdapter(new LowPass(1.0)), w);
	Apply.process(new FilterAdapter(new HighPass(2.0)), w);
	Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
    }

}
