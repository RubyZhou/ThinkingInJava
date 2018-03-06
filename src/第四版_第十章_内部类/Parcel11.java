package 第四版_第十章_内部类;

/**
 * Function	: Parcel11.java
 * Author	: zhouyf
 * Date		: 2018年3月5日
 * Version	: 1.0 
 * Desc		: 嵌套类(Nested Classes)
 *				(1) 外围类对象不是必须的
 *				(2) 无需 this引用
 * History	:
 */
public class Parcel11 {
	
	/* 嵌套类(1) */
	private static class ParcelContents implements Contents {
		private int i = 11;
		public int value() { return i; }
	}
	
	/* 嵌套类(2) */
	protected static class ParcelDestination implements Destination {
		private String label;
		private ParcelDestination(String whereTo) { label = whereTo; }
		public String readLabel() { return label; }
		
		/* 嵌套类可以包含其他  static 元素，包括： */
		// (1) 静态方法
		public static void f() {}
		// (2) 静态变量
		static int x = 10;
		// (3) 静态类
		static class AnotherLevel {
			public static void f() {}
			static int x = 10;
		}
	}
	/* 外部创建内部类的方法 */
	public static Destination destination(String s)	{ return new ParcelDestination(s); }
	public static Contents contents()				{ return new ParcelContents(); }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 这里调用 static 方法无需 new 一个Parcel11 后进行 p.contents();
		 */
		Contents c = contents();
		Destination d = destination("Tasmania");

	}

}
