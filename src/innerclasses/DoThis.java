package innerclasses;
/**
 * 内容	：在内部类中使用 this 关键字
 * 说明	：
 * 作者	：zhouyf
 * 日期	：2017年6月11日	上午12:09:38
 * 
 */

public class DoThis {
    void f() {
	System.out.println("DoThis.f()");
    }
    public class Inner {
	public DoThis outer() {
	    return DoThis.this;	// 通过外部类名 + .this 生成对外部类对象的应用
	}
    }
    public Inner inner() {
	// 创建一个内部类
	return new Inner();
    }
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	DoThis dt = new DoThis();
	DoThis.Inner dti = dt.inner();
	/* 类型 */
	dti.outer().f();	/* 等于通过内部类调用到外部类，再用外部类调用外部类的function */
	/* dti.outer() -> 返回一个外部类的引用 */
    }

}
