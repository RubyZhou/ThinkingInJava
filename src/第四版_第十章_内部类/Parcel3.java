package 第四版_第十章_内部类;
/**
 * Function	: 应用 .new
 * Author	: 
 * Date		: [2018-02-22]
 * Desc		: 使用 .new 来创建一个内部类的实例(good)，之前都是调用一个额外方法进行创建 -> 通过 return new 一个内部类的形式.
 * History	:
 */
public class Parcel3 {
	class Contents {
		private int i = 11;
		public int value() { return i; }
	}
	
	class Destination {
		private String label;
		// set
		Destination(String whereTo)	{ label = whereTo; }
		// get
		String readLabel() 			{ return label; }
	}
	
	public static void main(String[] args) {
		Parcel3 p = new Parcel3();
		Parcel3.Contents c = p.new Contents();
		Parcel3.Destination d = p.new Destination(Integer.toString(c.value()));
		System.out.println(d.readLabel());
		
	}
}
