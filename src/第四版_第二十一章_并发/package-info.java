/**
 * 
 */
/**
 * Function	: package-info.java
 * Author	: zhouyf
 * Date		: 2018年5月9日 
 * Version	: 1.0 
 * Desc		: 
 * History	:
 */
package 第四版_第二十一章_并发;

/*
 * (1) LiftOff.java	: 一个简单的线程任务 : (实现了 Runnale 接口) && (编写了 run() 方法)
 * (2) MainThread.java	: 【单线程调度】 ：通过  main() 线程完成 LiftOff.run()
 * (3) BasicThreads.java	: 【两个线程调度】 通过 Threads 来驱动 任务 : 本例创建了一个线程去执行 LiftOff.run(), 原 main() 线程与其同步执行
 * (4) MoreBasicThreads.java	: 【5个线程调度】：结果非确定性
 * () CachedThreadPool.java	: 使用 Executor 管理线程（线程池）
 */
