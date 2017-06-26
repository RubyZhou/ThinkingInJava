package interfaces;
/**
 * 内容	：
 * 说明	：
 * 作者	：zhouyf
 * 日期	：
 * 
 */

interface Monster {
    void menace(); 	//    n.威胁; 恐吓;
}

interface DangerousMonster extends Monster {
    void destory();
}

interface Lethal {
    void kill(); 	//    adj.致命的
}

class DragonZilla implements DangerousMonster {
    public void menace() {
	
    }
    public void destory() { }
}


public class HorrorShow {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
