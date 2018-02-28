package 第四版_第十章_内部类;

/**
 * Function	: Parcel8.java
 * Author	: zhouyf
 * Date		: 2018年2月28日
 * Version	: 1.0 
 * Desc		: 一个匿名类，所继承的基类带有构造函数，同时重写了基类的其他方法
 * History	:
 */
public class Parcel8 {

	// 外部类有一个 warpping()方法  返回一个 Warpping 类
	public Warpping wrapping(int x) {
		// (1) 返回一个接口(触发其构造函数，将参数传入)
		return new Warpping(x) {
			// (2) 使用匿名的内部类，对目标类方法进行重写
			public int value() {
				// (3) 调用了继承
				return super.value() * 47;
			}
		};
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parcel8 p = new Parcel8();
		Warpping w = p.wrapping(10);
		System.out.println(w.value());

	}

}
