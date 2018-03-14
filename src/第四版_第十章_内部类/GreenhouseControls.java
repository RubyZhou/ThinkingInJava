package 第四版_第十章_内部类;

import java.util.List;

/**
 * Function	: GreenhouseControls.java
 * Author	: zhouyf
 * Date		: 2018年3月12日
 * Version	: 1.0 
 * Desc		: 应用调度框架实例 : 温室控制（内部类的方式）
 * 				控制变化内容包括：
 * 				灯光，水，温度调节器开关，响铃，重新启动系统
 * History	:
 */


public class GreenhouseControls extends Controller{
	
	/* 
	 * 	【事件类 - 内部类实现】
	 * 
	 * 	【第I类 -状态控制类】灯光，水，温度调节器灯开关  	 <说明>	内部类方式，自由访问外围类字段，通常是硬件的控制( light/water/thermostat )
	 * 		(1)	构造器		:	调用基类构造器	-> 即设置一个沙漏大小, 开始倒计时
	 * 		(2)	action()	:	执行自身所需的对状态类开关的控制
	 * 		(3)	toString	:	only给个完成提示
	 */
	
	/* 
	 * 光照 : 开启/关闭
	 */
	private boolean light = false;		/* 默认：无光照 */
	public class LightOn extends Event {
		public LightOn(long delayTime)	{ super(delayTime); }		/* 【2-1-1】构造方法		: 直接使用基类的方法 */
		public void action()			{ light = true; }			/* 【2-1-2】action方法	: 覆盖基类（抽象方法）：修改控制变量 */
		public String toString()		{ return "Light is on"; }	/* 【2-1-3】 toString()	: 常规 */
	}
	
	public class LightOff extends Event {
		public LightOff(long delayTime) { super(delayTime); }
		public void action()			{ light = false; }
		public String toString()		{ return "Light is off"; }
	}
	
	/*
	 * 水 : 开启/关闭
	 */
	private boolean water = false;
	public class WaterOn extends Event {
		public WaterOn(long delayTime)	{ super(delayTime); }
		public void action()			{ water = true; }
		public String toString()		{ return "GreenHouse's Water is on";}
	}
	
	public class WaterOff extends Event {
		public WaterOff(long delayTime)	{ super(delayTime); }
		public void action()			{ water = false; }
		public String toString()		{ return "GreenHouse's Water is off";}
	}
	
	/*
	 * 【2-3】温控器 : 夜间/日间
	 */
	private String thermostat = "Day";
	public class thermostatNight extends Event {
		public thermostatNight(long delayTime)	{ super(delayTime); }
		public void action()			{ thermostat = "Night"; }
		public String toString()		{ return "Toermostat on night setting";}
	}
	
	public class thermostatDay extends Event {
		public thermostatDay(long delayTime)	{ super(delayTime); }
		public void action()					{ thermostat = "Day"; }
		public String toString()				{ return "Toermostat on Day setting";}
	}
	
	/*
	 * 【第II类 】铃响事件
	 * 		(1)	构造器		:	同 I 类一样, 直接调用 super 构造器
	 * 		(2)	action()	:	响铃的 action 就是创建自身的一个实例，调用外围类的方法 addEvent 主动加载到主控框架的队列里 -> 属于【多重继承】
	 * 							Q : 这里调用主控的addEvent 事件是加到哪里？ 加到外围类的队列中
	 * 		(3)	toString()
	 */
	public class Bell extends Event {
		public Bell(long delayTime)	{ super(delayTime); }
		public void action()		{ addEvent(new Bell(delayTime)); }	
		public String toString()	{ return "Bing!"; }	
	}
	
	/*
	 * 【第III类 】重启事件 	：	将一个 Event 列表给到 Restart，加到控制器上（注：指外围调度类接收到一个重启的事件请求）
	 * 		字段				:	自身有一个的队列,
	 * 		(1)	构造器		:	相较于上述构造器, 多一个输入 -> 即，将主控的事件队列输入进来。

	 * 		
	 * 			Q : 这里主控队列里都是一些未翻牌的事件，即时加到队尾原来的依然会 action ?
	 * 
	 * 		(2)	action()	:	遍历本地队列，重启沙漏，加载到主控队列尾
	 * 		(3)	toString()
	 */
	public class Restart extends Event {
		
		private Event[]	eventList;
		/*	构造器 :
		 * 	1) 调用下 super 的构造器, 重启倒计时
		 * 	2) 将本地队列指向主控队列
		 * 	3) 遍历主控队列, 逐个加载至主控队列队尾
		 */
		public Restart(long delayTime, Event[] evenList) { 
			super(delayTime); 			/* (1) 将重启事件进行倒计时准备 */
			this.eventList = evenList;	/* (2) 【重要说明】这里不是赋值操作，是将基类队列和本地队列绑定 */
			/* 
			 * (3) 遍历输入队列 , 加载到主控队尾: 
			 * 		这里  (Event e : eventList) ，即每次循环 ， 创建一个 e <=> 等价于使用eventList[n] 
			 */
			for (Event e : eventList) {	
				addEvent(e);
			}
		}
		/*
		 * action()方法	: 外围队列中，重启事件准备完毕后，重启事件对所有已存在的事件拨动倒计时准备
		 * 		(1) 遍历本地 eventList, 根据(最新的当前时间 + 输入的 delayTime) -> 开启计时器 ，加入本地事件队尾
		 * 		(2)	 开启重启事件倒计时准备
		 * 		(3)	在本地事件队尾增加重启事件，是排在已存在队列重启事件的前面
		 */
		public void action() { 
			for(Event e : eventList) {
				e.start();
				addEvent(e);
			}
			start();
			addEvent(this);
		}
		public String toString()		{ return "Restarting System..."; }
	}
	
	
	public static class Terminate extends Event {
		public Terminate(long delayTime)	{ super(delayTime); }
		public void action()				{ System.exit(0); }
		public String toString()			{ return "Terminating!"; }
	}

}
