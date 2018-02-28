package 第四版_第十章_内部类;

/**
 * Function	: Parcel7.java
 * Author	: zhouyf
 * Date		: 2018年2月28日
 * Version	: 1.0 
 * Desc		: 一个匿名的内部类，创建一个继承自接口的实例，返回实例时才进行定义 
 * 			  特点，没有类名的，继承了接口
 * History	:
 */
public class Parcel7 {

	/**
	 * @param args
	 */
	public Contents contents() {
		// return 创建一个实例的时候进行定义
		return new Contents() {
			private int i = 11;
			public int value() { return i; }
		};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
	}

}
