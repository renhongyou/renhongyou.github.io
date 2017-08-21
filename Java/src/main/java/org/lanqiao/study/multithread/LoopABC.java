package org.lanqiao.study.multithread;

/**
 * 经典面试题：<br/>
 * 建立三个线程，A线程打印10次A，B线程打印10次B，C线程打印10次C。<br/>
 * 要求线程同时运行，交替打印10次ABC。
 * @author 任宏友
 *
 */
public class LoopABC {
	static class PrinterThread implements Runnable {
		private String name;
		private Object pre; //前一个线程持有的对象锁
		private Object self; //自身对象锁
		private PrinterThread(String name, Object pre, Object self) {
			this.name = name;
			this.pre = pre;
			this.self = self;
		}
		@Override
		public void run() {
			int count = 10;
			while(count > 0) {
				synchronized(pre) {
					synchronized(self) {
						System.out.print(name);
						count--;
						self.notify();
					}
					try {
						pre.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}	
	public static void main(String[] args) throws InterruptedException {
	    Object a = new Object();     
	    Object b = new Object();
	    Object c = new Object();     
	    PrinterThread pA = new PrinterThread("A", c, a);     
	    PrinterThread pB = new PrinterThread("B", a, b);     
	    PrinterThread pC = new PrinterThread("C", b, c);     

	    new Thread(pA).start();  
	    Thread.sleep(100);  //确保按顺序A、B、C执行  
	    new Thread(pB).start();  
	    Thread.sleep(100);    
	    new Thread(pC).start();     
	    Thread.sleep(100);    
	}
}	
	

