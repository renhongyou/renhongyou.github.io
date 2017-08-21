package org.lanqiao.study.multithread;

/**
 * 实现多线程第一种手段：扩展java.lang.Thread类
 * @author 任宏友
 *
 */
class Thread1 extends Thread {
	private String name;
	/**
	 * 通过构造方法传递数据
	 * @param name
	 */
	public Thread1(String name) {
		super(name);
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 线程运行开始！");
		for(int i = 0; i < 5; i++) {
			System.out.println("子线程"+name + "运行 : " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		System.out.println(Thread.currentThread().getName() + " 线程运行结束！"); 
	}
}

/**
 * 实现多线程第二种手段：实现java.lang.Runnable接口
 * @author 任宏友
 *
 */
class Thread2 implements Runnable {
	private String name;
	/**
	 * 通过构造方法传递数据
	 * @param name
	 */
	public Thread2(String name) {
		this.name = name;
	}
	
	/**
	 * 通过变量和方法传递数据
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(name + "运行：" + i);
			try {
				Thread.sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}

/**
 * yield();：让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
 * @author 任宏友
 *
 */
class ThreadYield extends Thread {
	public ThreadYield(String name) {
		super(name);
	}
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		for(int i = 0; i <= 50; i++) {
			System.out.println(" " + this.getName() + "-----" + i);
			//当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（谁先抢到谁执行）
			if(30 == i) {
				this.yield();
			}
		}
	}
}

public class Test {
	/**
	 * 测试扩展Thread类的方法
	 */
	public static void test1() {
		Thread1 myThread1 = new Thread1("A");
		Thread1 myThread2 = new Thread1("B");
//		Thread1 myThread2 = myThread1; /* IllegalThreadStateException */	
		myThread1.start();
		myThread2.start();
	}
	
	/**
	 * 测试实现Runnable接口的方法
	 */
	public static void test2() {
		new Thread(new Thread2("C")).start();
		new Thread(new Thread2("D")).start();
	}
	
	/**
	 * 不加join();
	 */
	public static void testWithoutJoin() {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始！");  
        Thread1 myThread1=new Thread1("A");  
        Thread1 myThread2=new Thread1("B");  
        myThread1.start();  
        myThread2.start();  
        System.out.println(Thread.currentThread().getName() + "主线程运行结束！");  
	}
	
	/**
	 * 加入join();
	 */
	public static void testJoin() {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始！");  
        Thread1 myThread1=new Thread1("A");  
        Thread1 myThread2=new Thread1("B");  
        myThread1.start();  
        myThread2.start();  
        try {
			myThread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        try {
			myThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println(Thread.currentThread().getName() + "主线程运行结束！");  
	}
	
	/**
	 * 测试yield();，两种运行结果。<br/>
	 * 第一种情况：李四（线程）当执行到30时会CPU时间让掉，这时张三（线程）抢到CPU时间并执行。<br/>
	 * 第二种情况：李四（线程）当执行到30时会CPU时间让掉，这时李四（线程）抢到CPU时间并执行。
	 */
	public static void testYield() {
        ThreadYield yieldThread1 = new ThreadYield("张三");  
        ThreadYield yieldThread2 = new ThreadYield("李四");  
        yieldThread1.start();  
        yieldThread2.start();  		
	}
	
	public static void main(String[] args) {
//		test1();
//		test2();
//		testWithoutJoin();
//		testJoin();
		testYield();
	}
}
