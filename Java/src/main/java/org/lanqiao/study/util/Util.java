package org.lanqiao.study.util;

public class Util {
	/**
	 * 获取指定范围指定个数的随机数组成的数组
	 * @param length
	 * @param min
	 * @param max
	 * @return
	 */
	public static int[] getRandomArr(int length, int min, int max) {
		int[] arr = new int[length];
		for(int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * (max + 1 - min) + min);
		}
		return arr;
	}
	
	/**
	 * 利用位运算符进行两数数值交换
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void swap(int[] arr, int i, int j) {
		if(i != j) {
			arr[i] ^= arr[j];
			arr[j] ^= arr[i];
			arr[i] ^= arr[j];		
		}
	}
	
	/**
	 * 获取一个正整数的位数
	 * @param num
	 * @return
	 */
	public static int digit(int num) {
		if(num < 0) {
			return 0;
		}
		int m = 1;
		for(int i = 0; i < (int) Math.log10(num); i++) {
			m *= 10;
		}
		return num / m;
	}
}
