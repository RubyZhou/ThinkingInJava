package 第四版_第十章_内部类;

/**
 * Function	: Games.java
 * Author	: zhouyf
 * Date		: 2018年3月5日
 * Version	: 1.0 
 * Desc		: 匿名内部类方式的工厂方法应用实例：匿名内部类在游戏框架中的应用
 * History	:
 */
import static util.Print.*;

interface Game			{ boolean move(); }
interface GameFactory	{ Game getGame(); }

class Checkers implements Game {
	private Checkers() {}
	private int moves = 0;
	private static final int MOVES = 3;
	/*
	 * 实现接口的 move()
	 * @see 第四版_第十章_内部类.Game#move()
	 */
	public boolean move() {
		print("Checkers move " + moves);
		return ++moves != MOVES;
	}
	
	public static GameFactory factory = 
			/*
			 * 内部类实现工厂接口
			 */
			new GameFactory() {
				public Game getGame() { return new Checkers(); }
			};
}

class Chess implements Game {
	private Chess() {}
	private int moves = 0;
	private static final int MOVES = 4;
	public boolean move() {
		print("Chess move " + moves);
		return ++moves != MOVES;
	}
	
	public static GameFactory factory = 
			new GameFactory() {
				public Game getGame() { return new Chess(); }
			};
}

public class Games {

	/**
	 * @param args
	 */
	public static void playGame(GameFactory factory) {
		Game s = factory.getGame();
		while(s.move())
			;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playGame(Checkers.factory);
		playGame(Chess.factory);
	}

}
