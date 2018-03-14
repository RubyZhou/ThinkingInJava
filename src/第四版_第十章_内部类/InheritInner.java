package 第四版_第十章_内部类;

/**
 * Function	: InheritInner.java
 * Author	: zhouyf
 * Date		: 2018年3月14日
 * Version	: 1.0 
 * Desc		: 继承某个类的内部类 : 必须在导出类的构造器中调用  enclosingClassReference.super() 外围类的引用
 * 				
 * History	:
 */

/*
 * 一个带内部类的类
 */
class WithInner {
	class Inner{}
}

/*
 * 继承某个类的内部类
 */
public class InheritInner extends WithInner.Inner {
	
	/*【非法】常规构造器不行*/
	//!InheritInner()	{}
	
	/*【正确】构造器 : 传入一个构造器的外围类 -> 调用外围类的引的 super()*/
	InheritInner(WithInner wi) {
		wi.super();
	}

	public static void main(String[] args) {
		// 使用方法
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
	}
}







