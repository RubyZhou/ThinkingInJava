/**
 * 
 */
package innerclasses;
/**
 * 内容	：创建一个内部类
 * 说明	：
 * 作者	：zhouyf
 * 日期	：
 * 
 */


public class Parcel1 {
    
    class Contents {
	/* 在类内部创建的类 */
	private int i = 11;
	public int value() {
	    return i;
	}
    }
    
    class Destination {
	private String label;
	Destination(String whereTo) {
	    label = whereTo;
	}
	String readLable() { return label; }
    }
    
    public void ship(String dest) {
	Contents c = new Contents();
	Destination d = new Destination(dest);
	System.out.println(d.readLable());
    }
    
    
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Parcel1 p = new Parcel1();
	p.ship("today is a good day!");
    }

}











