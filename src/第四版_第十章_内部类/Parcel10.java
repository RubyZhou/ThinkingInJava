package 第四版_第十章_内部类;

/**
 * Function	: Parcel10.java
 * Author	: zhouyf
 * Date		: 2018年2月28日
 * Version	: 1.0 
 * Desc		: 带实例初始化的匿名内部类
 * History	:
 */
public class Parcel10 {

	/**
	 * @param args
	 */
	public Destination destination(final String dest, final float price) {
		return new Destination() {
			private int cost;
			//匿名内部类的构造方法
			{ 
				cost = Math.round(price);
				if (cost > 100)
					System.out.println("Over budget!");
			}
			private String label = dest;
			public String readLabel() { return label; }
		};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parcel10 p = new Parcel10();
		Destination d = p.destination("Tasmania", 101.395F);
	}

}
