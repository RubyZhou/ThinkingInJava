package 第四版_第十章_内部类;


/**
 * Function	: 客户端程序员对 private / protected 类型的内部类访问
 * Author	: zhouyf
 * Date		: [2018-02-24]
 * Desc		: 在 Parcel3 基础上增加了 private / protected 类型的内部类
 * History	:
 */
class Parcel4 {
	/*
	 * 内部类 : 继承外部接口 
	 */
	private class PContents implements Contents {
		private	int i = 11;
		public	int	value() { return i; }
	}
	
	/*
	 * 内部类 : 继承外部接口 
	 */
	protected class PDestination implements Destination {
		private String label;
		// 构造方法
		private PDestination(String whereTo) {
			label = whereTo;
		}
		public String readLabel() { return label; }
	}
	
	/*
	 * 供外部创建内部类实例
	 */
	public Destination destination(String s) {
		return new PDestination(s);
	}
	public Contents contents() {
		return new PContents();
	}
}

/*
 * 这是一个客户端程序员的测试代码
 */
public class TestParcel {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* (1) 创建一个外部类实例 */
		Parcel4 p = new Parcel4();
		
		// (2) 通过外部类实例创建一个内部类实例 with 特定方法
		Contents c = p.contents();
		Destination d = p.destination("Tasmania");

		/*
		 *  下列语句非法：不能访问私有类
		 *  原因：
		 *  	PContents 是  private 的，如果是 public 则下列语句正确
		 *  	
		 *  	PContents		是  private	, 除  Parcel4(类的设计者)外，没有人可以访问
		 *  	PDestination	是  protected	, 除  Parcel4 及其子类 and 同一个包中的类, 其他不能访问
		 *  	=> 客户端程序员不能访问到这些个名字
		 *  解决方案 ：
		 *  	如上
		 */
		//! Parcel4.PContents pc = p.new PContents();
	}

}
