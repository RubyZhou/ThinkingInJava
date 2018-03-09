package 第四版_第十章_内部类;

/**
 * Function	: MultiImplementation.java
 * Author	: zhouyf
 * Date		: 2018年3月9日
 * Version	: 1.0 
 * Desc		: 多重继承：通过匿名内部类，同时继承了具体类和抽象类
 * History	:
 */

class D {}

abstract class E { }

/* (1) Z 继承了一个具体类 D, 并且以匿名内部类的方式继承了抽象类 E（只需要调用一个方法，就可以把他当作E来使用） */
class Z extends D {
	E makesE() { return new E() {}; }
}


public class MultiImplementation {

	/* (2) 同样测试类的两个方法，需要两个类似接口作为输入 */
	static void takesD(D d) {}
	static void takesE(E e) {}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Z z = new Z();
		/* (3) 仅需一个Z通过多重继承即可  */
		takesD(z);
		takesE(z.makesE());
	}

}
