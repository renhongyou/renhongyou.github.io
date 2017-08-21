package org.lanqiao.study.sorts;

import java.util.Arrays;

import org.lanqiao.study.util.Util;

/**
 * 希尔排序（缩小增量排序）
 * 平均时间复杂度：O(nlgn) 不稳定
 * 空间复杂度：O(1)
 * 算法思想：
 * 1. 选择一个增量序列t1, t2, ..., tk，其中ti > tj，tk = 1；
 * 2. 按增量序列个数k，对序列进行k趟排序；
 * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @author 任宏友
 *
 */
public class ShellSort {
	public static void shellSort(int[] arr) {
		shellSort(arr, 0, arr.length - 1);
	}

	private static void shellSort(int[] arr, int left, int right) {
		int half = right + 1;
		while(true) {
			half = half / 2;
			for(int i = 0; i < half; i++) {
				for(int j = i + half; j < right + 1; j = j + half) {
					int temp = arr[j];
					int k = 0;
					for(k = j - half; k >= 0 && arr[k] > temp; k = k - half) {
						arr[k + half] = arr[k];
					}
					arr[k + half] = temp;
				}
			}
			if(1 == half) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = Util.getRandomArr(20, 1, 100);
		System.out.println("begin..." + Arrays.toString(arr));
		shellSort(arr);
		System.out.println("final..." + Arrays.toString(arr));
	}
}
