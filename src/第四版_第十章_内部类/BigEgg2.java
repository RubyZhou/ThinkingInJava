package 第四版_第十章_内部类;

import static 第四版_源码_util.Print.*;

class Egg2 {
	protected class Yolk {
		public Yolk() 	{ print("Egg2.Yolk!"); }
		public void f()	{ print("Egg2.Yolk.f()!"); }
	}
	
	private Yolk y = new Yolk();
	
	public Egg2() 						{ print("New Egg2"); }
	public void insteadYolk(Yolk yy)	{ y = yy; }
	public void g()						{ y.f(); }
}

public class BigEgg2 extends Egg2 {
	
	/* 特别指明继承自基类的某个内部类， 名字也一样 */
	public class Yolk extends Egg2.Yolk {
		public Yolk() 	{ print("BigEgg2.Yolk!"); }
		public void f()	{ print("BigEgg2.Yolk.f()"); }
	}
	
	/* 这里 new 的是导出类的 Yolk， 但是初始化之前会初始化他所继承的 Egg2.Yolk */
	public BigEgg2()	{ insteadYolk(new Yolk()); }	
	
	public static void main(String[] args) {
		
		Egg2 e2 = new BigEgg2();
		e2.g();
		/*
		 * 输出：
		 * ------------------------------
		 * Egg2.Yolk!		// BigEgg2 构造器中 new Yolk() -> 调用 BigEgg2 中的 Yolk -> 因为是继承的，所以会先去调用 Egg2.Yolk 
		 * New Egg2			// 基类构造器初始化
		 * Egg2.Yolk!		// 回过头来初始化导出类 Yolk
		 * BigEgg2.Yolk!	// 导出类构造器初始化
		 * BigEgg2.Yolk.f()	// 导出类的 Yolk的f()
		 * ------------------------------
		 */
	}

}
