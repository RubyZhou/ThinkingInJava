package 第四版_第十章_内部类;

/**
 * Function	: 使用 .new
 * Author	: 
 * Date		: [2018-02-22]
 * Desc		: (1) 创建外围类中内部类实例方法 : 外围类实例.new 内部类(); 
 * 			  (2) 必须先创建外围类对象后才能创建其内部类对象
 * History	:
 */

public class DotNew {
	
	public class Inner {}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DotNew dn = new DotNew();
		DotNew.Inner dni = dn.new Inner();
	}

}
