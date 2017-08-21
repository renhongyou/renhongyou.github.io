package org.lanqiao.study.sorts;

import java.util.Arrays;

import org.lanqiao.study.util.Util;

/**
 * 选择排序
 * 平均时间复杂度：O(n^2) 不稳定
 * 空间复杂度：O(1)
 * 算法思想：
 * 1. 初始状态：无序区为R[1 ... n]，有序区为空；
 * 2. 第i趟排序(i=1,2,3…n - 1)开始时，当前有序区和无序区分别为R[1 ... i - 1]和R(i ... n)，
 * 该趟排序从当前无序区中选出关键字最小的记录R[k]，将它与无序区的第1个记录R交换，
 * 使R[1 ... i]和R[i + 1 .... n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * 3. n - 1趟结束，数组有序化。
 * @author 任宏友
 *
 */
public class SelectionSort {
	public static void selectionSort(int[] arr) {
		selectionSort(arr, 0, arr.length - 1);
	}
	
	private static void selectionSort(int[] arr, int left, int right) {
		if(null == arr || left == right) {
			return;
		}
		int minIndex = 0;
		for(int i = 0; i < right; i++) {
			minIndex = i;
			for(int j = i + 1; j < right + 1; j++) {
				if(arr[j] < arr[minIndex]) {
					//寻找最小的数，然后将其索引保存
					minIndex = j;
				}
			}
			Util.swap(arr, minIndex, i);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = Util.getRandomArr(20, 1, 100);
		System.out.println("begin..." + Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("final..." + Arrays.toString(arr));
	}
}
