package org.lanqiao.study.sorts;

import java.util.Arrays;

import org.lanqiao.study.util.Util;

/**
 * 插入排序
 * 平均时间复杂度：O(n^2) 稳定
 * 空间复杂度：O(1)
 * 算法思想：
 * 1. 从第一个元素开始，该元素可以认为已经被排序；
 * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 5. 将新元素插入到该位置后；
 * 6. 重复步骤2~5。
 * @author 任宏友
 *
 */
public class InsertionSort {
	public static void insertionSort(int[] arr) {
		insertionSort(arr, 0, arr.length - 1);
	}

	private static void insertionSort(int[] arr, int left, int right) {
		if(null == arr || left == right) {
			return;
		}
		for(int i = left + 1; i <= right; i++) {
			int value = arr[i];
			int pre = i - 1;
			while(pre >= left && arr[pre] > value) {
				arr[pre + 1] = arr[pre];
				pre--;
			}
			arr[pre + 1] = value;
		}		
	}
	
	public static void main(String[] args) {
		int[] arr = Util.getRandomArr(20, 1, 100);
		System.out.println("begin..." + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("final..." + Arrays.toString(arr));
	}
}
