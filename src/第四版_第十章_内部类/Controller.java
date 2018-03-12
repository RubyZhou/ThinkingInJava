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

public class Controller {

	/* 【1】创建一个List<Event> 变量，用 ArrayList 实现 */
	private List<Event> eventList = new ArrayList<Event>();
	
	/*
	 * 【2】添加功能
	 */
	public void addEvent(Event c) {
		eventList.add(c);
	}
	/*
	 * 【3】添加完毕后，循环处理事件
	 * 		【IDEA】：做成线程池进行处理？
	 * 		处理逻辑：遍历 eventList -> 循环取出 Event -> 准备完毕就执行 -> 移除处理完的事项
	 * 		TIPS：这个框架并不关心 Event 到底做了什么  => 将变化的事物分离
	 */
	public void run() {
		while (eventList.size() > 0) {
			/* 【4】寻找准备就绪的 Event， 将 eventList*/
			for (Event e : new ArrayList<Event>(eventList)) {
				if (e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}	/* if */
			}	/* for */
		} /* while */
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
