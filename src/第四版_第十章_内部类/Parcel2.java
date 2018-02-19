package 第四版_第十章_内部类;
/**
 * Function	: 
 * Author	: 
 * Date		: [2018-02-13]
 * Desc		: 外部类有一个方法，该方法返回一个指向内部类的引用，参见 to() 和 contents() 方法
 * History	:
 */
public class Parcel2 {
	/*
	 * 内部类1
	 */
	class Contents {
		private int i = 11;
		public int value() {
			return i;
		}
	}
	
	/*
	 * 内部类2
	 */
	class Destination {
		private String label;
		Destination(String whereTo) {
			label = whereTo;
		}
		String readLabel() { return label; } 
	}	
	
	/*
	 * 返回一个内部类的实例
	 */
	public Destination to(String s) {
		return new Destination(s);
	}
	
	public Contents contents() {
		return new Contents();
	}
	
	/*
	 * 创建内部类的实例
	 */
	public void ship(String dest) {
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parcel2 p = new Parcel2();
		p.ship("Tasmania");	//生成了 contents 和 destination 实例
		Parcel2 q = new Parcel2();	//再创建一个主类
		// Defining referrences to inner classes
		Parcel2.Contents c = q.contents();	// 这里的 c 和 d 实际是指向已经创建了的contents
		Parcel2.Destination d = q.to("Borneo");
	}
}
