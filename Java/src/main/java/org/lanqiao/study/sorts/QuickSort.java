package org.lanqiao.study.sorts;

import java.util.Arrays;

import org.lanqiao.study.util.Util;

/**
 * 快速排序
 * 平均时间复杂度：O(nlgn) 不稳定
 * 空间复杂度：O(lgn)
 * 算法思想：
 * 1. 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 3. 递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * @author 任宏友
 * 
 */
public class QuickSort {
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	private static void quickSort(int[] arr, int left, int right) {
		if(null == arr || left == right) {
			return;
		}
		int mid = partition(arr, left, right);
		quickSort(arr, left, mid - 1);
		quickSort(arr, mid + 1, right);
	}

	/**
	 * 分区算法
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		while(left < right) {
			while(left < right && arr[right] >= pivot) {
				//从右侧往左寻找更小值
				right--;
			}
			//将较小值往左侧调整
			arr[left] = arr[right];
			while(left < right && arr[left] <= pivot) {
				//从左侧往右寻找更大值
				left++;
			}
			//将较大值往右侧调整
			arr[right] = arr[left];
		}
		arr[left] = pivot;
		System.out.println("..." + left + "..." + Arrays.toString(arr));
		return left;
	}
	
	public static void main(String[] args) {
		int[] arr = Util.getRandomArr(20, 1, 100);
		System.out.println("begin..." + Arrays.toString(arr));
		quickSort(arr);
		System.out.println("final..." + Arrays.toString(arr));
	}
}
