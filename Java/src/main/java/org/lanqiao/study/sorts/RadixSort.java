package org.lanqiao.study.sorts;

import java.util.Arrays;

import org.lanqiao.study.util.Util;

/**
 * 基数排序
 * 平均时间复杂度：O(kn) 稳定
 * 空间复杂度：O(k + n)
 * 算法思想：
 * 1. 取得数组中的最大数，并取得位数；
 * 2. arr为原始数组，从最低位开始取每个位组成radix数组；
 * 3. 对radix进行计数排序（利用计数排序适用于小范围数的特点）。
 * @author 任宏友
 *
 */
public class RadixSort {
	public static void radixSort(int[] arr, int digit) {
		radixSort(arr, 0, arr.length - 1, digit);
	}
	
	private static void radixSort(int[] arr, int left, int right, int digit) {
		//此处应该事先知道整组数据的最大值有几位
		//控制键值
		int k = 0;
		int n = 1;
		int m = 1;
		//数组temp的第一维表示可能的余数0-9
		int[][] temp = new int[10][right + 1];
		//数组order用来表示该位是i的数的个数
		int[] order = new int[10];
		while(m <= digit) {
			for(int i = 0; i <= right; i++) {
				int lsd = ((arr[i] / n) % 10);
				temp[lsd][order[lsd]] = arr[i];
				order[lsd]++;
			}
			for(int i = 0; i < 10; i++) {
				if(0 != order[i]) {
					for(int j = 0; j < order[i]; j++) {
						arr[k] = temp[i][j];
						k++;
					}
				}
				order[i] = 0;
			}
			n *= 10;
			k = 0;
			m++;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = Util.getRandomArr(20, 1, 99);
		System.out.println("begin..." + Arrays.toString(arr));
		radixSort(arr, 2);
		System.out.println("final..." + Arrays.toString(arr));
	}
}
