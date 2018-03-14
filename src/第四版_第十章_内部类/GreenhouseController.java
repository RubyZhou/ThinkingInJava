package 第四版_第十章_内部类;

/**
 * Function	: GreenhouseController.java
 * Author	: zhouyf
 * Date		: 2018年3月12日
 * Version	: 1.0 
 * Desc		: 初始化 Greenhouse 系统
 * History	:
 */

import 第四版_第十章_内部类.Controller.*;
//{Args: 5000}

public class GreenhouseController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 创建一个主控调度 */
		GreenhouseControls gc = new GreenhouseControls();
		
		/* 900一响铃 */
		gc.addEvent(gc.new Bell(2000000000));
		
		/* (1) 普通加入一个事件 */
		gc.addEvent(gc.new LightOn(200));
		//gc.addEvent(gc.new LightOff(2000000000));
		
		/* (2) 数组载入 。只是 new了事件，没有载入队列，调用构造器，不会触发 action()*/
		Event[] eventList = {
			gc.new thermostatNight(0),
			gc.new LightOn(200),
			gc.new LightOff(400),
			gc.new WaterOn(600),
			gc.new WaterOff(800),
			gc.new thermostatDay(1400)
		};
		
		/* (3) 定时重启系统，载入上面的数组 */
		gc.addEvent(gc.new Restart(2000000000, eventList));	
		if (args.length == 1)
			gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
		gc.run();
	}

}
