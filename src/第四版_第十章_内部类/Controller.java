package 第四版_第十章_内部类;



/**
 * Function	: Controller.java
 * Author	: zhouyf
 * Date		: 2018年3月12日
 * Version	: 1.0 
 * Desc		: 事件调度基本框架 : 运行框架
 * 			(*)	补充点
 * 				List<Event> 类型，读作 Event的列表
 * 					add()	:	将一个 Object 添加到 List 的队尾
 * 					size()	:	获取 List 的元素个数
 * 					remove():	从 List 移除指定Event
 * 					foreach	:	连续获取 List 中的 Event
 * 						foreach的语句格式：
 * 						for(元素类型t 元素变量x : 遍历对象obj){
 * 							 引用了x的java语句;
 * 						}
 * History	:
 */

import util.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 事件调度框架:
 * 		(1) 有一个事件队列 List<Event> eventList
 * 		(2) 添加事件	:	像队尾添加输入的事件
 * 		(3)	后台运行	:	后台运行监控，队列里包含
 * 
 * 调度基本逻辑:
 * 		先向队列数组里装数据 -> 监控跑起来
 */
public class Controller {

	/* 【1】事件队列容器
	 * 	创建一个List<Event> 变量，用 ArrayList 实现 */
	private List<Event> eventList = new ArrayList<Event>();
	
	/*
	 * 【2】向队列中装载事件
	 */
	public void addEvent(Event c) {
		eventList.add(c);
	}
	/*
	 * 【3】控制器在后台开启：功能就是在事件队列里不断的检查 准备好的 事件，然后触发他的 action
	 * 		【IDEA】：做成线程池进行处理？
	 * 		TIPS：这个框架并不关心 Event 到底做了什么  => 将变化的事物分离
	 */
	public void run() {
		/* 【4】队列 里包含未处理的事件 ，继续监控; 否则,结束。 */
		while (eventList.size() > 0) {
			/* 新建一个空的队列，将现有的队列装进去后，从头到尾遍历一遍 */
			for (Event e : new ArrayList<Event>(eventList)) {
				/* 遍历过程将已经 ready 的事件"翻牌" (触发他的action后就从队列中移除)。再从头检查一遍 */
				if (e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
