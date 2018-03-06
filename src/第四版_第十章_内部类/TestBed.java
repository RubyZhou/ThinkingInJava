package 第四版_第十章_内部类;

/**
 * Function	: TestBed.java
 * 			  {main: TestBed$Tester}
 * Author	: zhouyf
 * Date		: 2018年3月6日
 * Version	: 1.0 
 * Desc		: 代替main()的测试用内部类
 * History	:
 */
public class TestBed {
	public void f() { System.out.println("f()"); }
	public static class Tester {
		public static void main(String[] args) {
			TestBed t = new TestBed();
			t.f();
		}
	}
}
