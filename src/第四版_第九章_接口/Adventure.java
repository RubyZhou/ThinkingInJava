package 第四版_第九章_接口;
/**
 * 内容	：Java中的多重继承
 * 说明	：
 * 作者	：zhouyf
 * 日期	：
 * 
 */
interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() { /* fight的实现  */ }
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {
//    Hero is a CanFight, is a CanSwim, is a CanFly , 还是一个 ActionCharacter
    
    /* 继承了基类的 fight  */
    public void swim() { /* swim的实现  */ }
    public void fly() { /* fly的实现  */ }
}


public class Adventure {
    public static void t(CanFight x)	{ x.fight(); }
    public static void u(CanSwim x)	{ x.swim();  }
    public static void v(CanFly x)	{ x.fly();   }
    public static void w(ActionCharacter x) {
	x.fight();
    }
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Hero h = new Hero();
	t(h);
	

    }

}
