package 第四版_第十章_内部类;

/**
 * Function	: 一个定义在作用域中的内部类，此作用域在方法内部
 * Author	: zhouyf
 * Date		: 2018年2月26日
 * Version	: 1.0 
 * Desc		: 内部类在其作用域外都是不可用的，如：不一定是方法的作用域，if {} 作用域也是如此
 * History	:
 */
public class Parcel6 {

	private void internalTracking(boolean b) {
		if(b) {
			/* 在条件语句中的内部类
			 * ================================================ */
			class TrackingSlip {
				private String id;
				
				TrackingSlip(String s)	{ id = s; }
				String getSlip() 		{ return id; }
			}
			/* ================================================ */
			TrackingSlip ts = new TrackingSlip("slip");
			String s = ts.getSlip();
		}
		/**
		 * 注意事项 ：在条件语句的外部, 尽管在同一个方法中，但是不能使用这个内部类 ！！
		 */
		// ! TrackingSlip ts = new Trackingslip("xxx");
	}
	
	/* 外部类中用来调用的方法 */
	public void track() { internalTracking(true); }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Parcel6 p = new Parcel6();
		p.track();
	}

}
