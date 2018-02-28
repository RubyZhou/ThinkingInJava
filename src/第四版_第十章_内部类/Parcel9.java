package 第四版_第十章_内部类;

/**
 * Function	: Parcel9.java
 * Author	: zhouyf
 * Date		: 2018年2月28日
 * Version	: 1.0 
 * Desc		: 验证匿名内部类所访问的外部变量必须是 final 的，否则报错
 * History	: 
 */
public class Parcel9 {
	
	public Destination detination(final String dest) {
		return new Destination() {
			// 这里在内部类中，访问了内部类外部的变量
			private String label = dest;
			public String readLabel() { return label; }
		};
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parcel9 p = new Parcel9();
		Destination d = p.detination("Tasmania");
	}

}
