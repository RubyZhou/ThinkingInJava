package 第四版_第十章_内部类;

/**
 * Function	: Event.java
 * Author	: zhouyf
 * Date		: 2018年3月12日
 * Version	: 1.0 
 * Desc		: 
 * History	: 控制事件的接口, 事件调度基本框架。 开始 -> 准备 -> 执行
 * 				【e.g】 延时拍照：设置延迟时间 -> 倒计时(支持重置开始时间) -> 拍 
 */


public abstract class Event {
	private long eventTime;
	protected final long delayTime;		// 设置的延时是固定的
	
	public Event(long delayTime) {
		this.delayTime = delayTime;
		start();
	}
	
	/*
	 *  【1】在固定延时增加一个基准时间; 
	 *  Tips : 未放在构造器中, 所以可以支持重启
	 */
	public void start() {
		/* 当前时间 + 输入的延时 */
		eventTime = System.nanoTime() + delayTime;	
	}
	
	/*
	 * 【2】负责 action() 的触发条件控制，可以在导出类中覆盖，让事件支持其他的触发因素
	 */
	public boolean ready() {
		return System.nanoTime() >= eventTime;
	}
	
	/*
	 * 【3】执行
	 */
	public abstract void action();
}
