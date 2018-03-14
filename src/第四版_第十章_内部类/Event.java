package 第四版_第十章_内部类;

/**
 * Function	: Event.java
 * Author	: zhouyf
 * Date		: 2018年3月12日
 * Version	: 1.0 
 * Desc		:  控制事件的接口, 事件调度基本框架。 开始 -> 准备 -> 执行
 * 				事件类接口: 
 * 				(1) 构造器	:	输入沙漏大小, 并触发倒计时
 * 				(2)	准备		:	判断沙漏完成？
 * 				(3) 执行		:	每个事件都有各自的执行内容
 * History	: 
 * 
 */

/*

 */
public abstract class Event {
	private long eventTime;				// ready完成时间点，供判断用
	protected final long delayTime;		// 沙漏大小，间隔时长
	
	public Event(long delayTime) {
		//System.out.println("---Event构造器: " + delayTime);
		this.delayTime = delayTime;
		start();
	}
	
	/*
	 *  【1】设置事件的结束点，即开始进行倒计时：
	 *  	在固定延时增加一个基准时间; 
	 *  	Tips : 未放在构造器中, 所以可以支持重启
	 */
	public void start() {
		/* 当前时间 + 输入的延时 */
		eventTime = System.nanoTime() + delayTime;
		//System.out.println("eventTime = " + eventTime);
	}
	
	/*
	 * 【2】	是否倒计时完成，可以在导出类中覆盖，让事件支持其他的触发因素
	 */
	public boolean ready() {
		return System.nanoTime() >= eventTime;
	}
	
	/*
	 * 【3】执行
	 */
	public abstract void action();
}
