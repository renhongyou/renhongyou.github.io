package org.lanqiao.study.multithread;

/**
 * 一个简单的死锁类。<br/>
 * 当DeadLock类的对象flag为1时（thread1），先锁定obj1，睡眠500毫秒。<br/>
 * 而thread1在睡眠的时候另一个flag为0的对象（thread2）线程启动，先锁定obj2，睡眠500毫秒。<br/>
 * thread1睡眠结束之后需要锁定obj2才能继续执行，而此时obj2已被thread2锁定。<br/>
 * thread2睡眠结束之后需要锁定obj1才能继续执行，而此时obj1已被thread1锁定。<br/>
 * thread1、thread2相互等待，都需要得到对方锁定的资源才能继续执行，从而死锁。
 * @author 任宏友
 *
 */
public class DeadLock implements Runnable {
	public int flag = 1;
	private static Object obj1 = new Object();
	private static Object obj2 = new Object();
	
	@Override
	public void run() {
		System.out.println("flag = " + flag);
		if(1 == flag) {
			synchronized(obj1) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(obj2) {
					System.out.println("1");
				}
			}
		}
		if(0 == flag) {
			synchronized(obj2) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(obj1) {
					System.out.println("0");
				}
			}
		}
	}
	public static void main(String[] args) {
		DeadLock thread1 = new DeadLock();
		DeadLock thread2 = new DeadLock();
		thread1.flag = 1;
		thread2.flag = 0;
		//thread1、thread2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
		//thread2的run()可能在td1的run()之前运行。
		new Thread(thread1).start();
		new Thread(thread2).start();
	}
}
