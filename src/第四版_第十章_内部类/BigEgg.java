package 第四版_第十章_内部类;

import static 第四版_源码_util.Print.*;

class Egg {
	private Yolk y;
	protected class Yolk {
		public Yolk() { print("Egg.Yolk!");	}
	}
	
	public Egg() {
		print("New egg!");
		y = new Yolk();
	}
}

public class BigEgg extends Egg	{
	public class Yolk {
		public Yolk() { print("BigEgg.Yolk!"); }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new BigEgg();
		/*
		 * 输出内容：
		 * ------------------------------
		 * New egg.			// (1) 创建 BigEgg 实例 -> 触发基类 Egg 类构造器 -> 打印信息 
		 * Egg.Yolk!		// (2) Egg构造器创建一个内部类实例 Yolk -> 调用的是基类的 Yolk() 而非导出类的 Yolk();
		 * 
		 * 对(2)的原因说明：
		 * 		继承某个外部类后，对于这两个基类和导出类来说，他们各自的内部类都是独立的实体【通过namespace约束】，相互之间没有任何关系【即使是同名】
		 * ------------------------------
		 * 	
		 */
	}

}
