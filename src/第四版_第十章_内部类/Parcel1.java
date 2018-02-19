package 第四版_第十章_内部类;

/**
 * Function	: 创建内部类
 * Author	: 
 * Date		: [2018-02-11]
 * Desc		: 
 * History	:
 */
public class Parcel1 {
	
	/**
	 * 内部类1 ：在类中创建一个简单的内部类
	 */
	class Contents {
		private int i = 11;
		public int value() {
			return i;
		}
	}
	
	/**
	 * 内部类2 : 带构造方法的内部类
	 */
	class Destination {
		private String label;
		Destination(String whereTo) { 
			label = whereTo; 
		}
		String readLabel() { return label; }
	}
	
	/*
	 * 调用内部类
	 */
	public void ship(String dest) {
		Contents c = new Contents();
		Destination d = new Destination(dest);
		System.out.println(d.readLabel());
	}
	
	/*
	 * 测试
	 */
	public static void main(String[] args) {
		Parcel1 p = new Parcel1();
		p.ship("Tasmania");
	}
	
}
