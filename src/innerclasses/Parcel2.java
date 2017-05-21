package innerclasses;
/**
 * 内容	：外部类返回一个内部类的引用
 * 说明	：
 * 作者	：zhouyf
 * 日期	：
 * 
 */


public class Parcel2 {
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
    
    public Destination to(String s) {
	return new Destination(s);
    }
    
    public Contents contents() {
	return new Contents();
    }
    public void ship(String dest) {
	Contents c = contents();
	Destination d = to(dest); //不是new出来的
	System.out.println(d.readLable());
    }
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Parcel2 p = new Parcel2();
	p.ship("Tasmania");

	Parcel2 q = new Parcel2();
	Parcel2.Contents c = q.contents();
	Parcel2.Destination d = q.to("Borneo");
    }

}
