package 第四版_第十章_内部类;

/**
 * Function	: 一个定义在方法中的内部类
 * Author	: zhouyf
 * Date		: [2018-02-26]
 * Desc		: 在外部类方法中创建内部类，内部类实现了某个接口
 * History	:
 */

public class Parcel5 {
	
	/*
	 * 外部类方法  :
	 * 		注意点 : 返回的是一个Destination 接口引用 ( 更粗粒度的类 )
	 */
	public Destination destination(String s) {
		/*
		 * 创建一个内部类：
		 * 		注意点 ：在外部类的方法中，而非外部类中 ！
		 */
		class PDestination implements Destination {
			private String label;
			private PDestination(String whereTo) {
				label = whereTo;
			}
			public String readLabel() { return label; }
		}
		/* 
		 * 返回一个内部类实例对象 : 
		 * 		优点 : 直接返回，连之前特地写一个方法返回内部类实例也不需要了 
		 */
		return new PDestination(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parcel5 p = new Parcel5();
		
		/* 这里直接调用外部类方法就可以了，连 .new 都不需要
		 * 		注意点 ： 这里发生了<向上转型> ，申请宽接口 Destination，细实现  PDestination。
		 */
		Destination d = p.destination("Tasmania");
	}
}
