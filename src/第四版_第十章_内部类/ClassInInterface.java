package 第四版_第十章_内部类;

/**
 * Function	: ClassInInterface.java
 * Author	: zhouyf
 * Date		: 2018年3月5日
 * Version	: 1.0 
 * Desc		: 嵌套类放在 interface 内部实现, 创建实例调用接口方法的方式 : 内部类().内部类方法()
 * History	:
 */

public interface ClassInInterface {

	void howdy();
	
	/*
	 * 居然在接口内部实现了接口（黑人脸...）
	 */
	class Test implements ClassInInterface {
		public void howdy() {
			System.out.println("Howdy!");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test().howdy();
	}

}
