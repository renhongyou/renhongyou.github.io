package org.lanqiao.study.sorts;

import java.util.Arrays;

import org.lanqiao.study.util.Util;

/**
 * 冒泡排序
 * 平均时间复杂度：O(n^2) 稳定
 * 空间复杂度：O(1)
 * 算法思想：
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3. 针对所有的元素重复以上的步骤，除了最后一个；
 * 4. 重复步骤1~3，直到排序完成。
 * @author 任宏友
 *
 */
public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		bubbleSort(arr, 0, arr.length - 1);
	}

	private static void bubbleSort(int[] arr, int left, int right) {
		if(null == arr || left == right) {
			return;
		}
		for(int i = left; i <= right; i++) {
			boolean ordered = true;
			for(int j = left; j < right - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					Util.swap(arr, j, j + 1);
					ordered = false;
				}
			}
			if(ordered) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = Util.getRandomArr(20, 1, 100);
		System.out.println("begin..." + Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("final..." + Arrays.toString(arr));
	}
}
