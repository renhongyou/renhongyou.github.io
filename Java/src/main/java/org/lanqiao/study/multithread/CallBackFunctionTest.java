package org.lanqiao.study.multithread;

/**
 * 有些应用需要在线程运行的过程中动态地获取数据。<br/>
 * run方法产生了3个随机数，然后通过Work类的process方法求着三个随机数的和，通过Data类的value返回结果。<br/>
 * 在返回value之前，必须要得到三个随机数。也就是说，这个value是无法事先传入线程类的。
 * @author 任宏友
 *
 */
public class CallBackFunctionTest extends Thread {
	private Work work;
	public CallBackFunctionTest(Work work) {
		this.work = work;
	}
	
	@Override
	public void run() {
		java.util.Random random = new java.util.Random();
		Data data = new Data();
		int n1 = random.nextInt(1000);
		int n2 = random.nextInt(2000);
		int n3 = random.nextInt(3000);
		Integer[] numbers = {n1, n2, n3};
		work.process(data, numbers); //使用回调函数
		System.out.println(String.valueOf(numbers[0] + " + " + String.valueOf(numbers[1]) + " + " + 
				String.valueOf(numbers[2]) + " = " + data.value));
	}
	public static void main(String[] args) {
		Thread thread = new CallBackFunctionTest(new Work());
		thread.start();
	}
}
class Data {
	public int value = 0;
}
class Work {
	public void process(Data data, Integer[] numbers) {
		for(int num : numbers) {
			data.value += num;
		}
	}
}
