package org.lanqiao.study.sorts;

import java.util.Arrays;

import org.lanqiao.study.util.Util;

/**
 * 归并排序
 * 平均时间复杂度：O(nlgn) 稳定
 * 空间复杂度：O(n)
 * （分治并递归，层数为lgn，每层循环次数为c*n，c为常数）
 * 算法思想：
 * 1. 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2. 对这两个子序列分别采用归并排序；
 * 3. 将两个排序好的子序列合并成一个最终的排序序列。
 * @author 任宏友
 *
 */
public class MergeSort {
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	/**
	 * 分成两段分别排序，然后合并
	 * 数组规模较小的情况下，使用插入排序算法提高效率
	 * @param arr
	 * @param left
	 * @param right
	 */
	private static void mergeSort(int[] arr, int left, int right) {
		if(null == arr || left == right) {
			return;
		}
		int mid = (left + right) / 2;
		if(right - left + 1 <= 16) {
			//数组个数小于16，则不适用递归，使用插入排序
			InsertionSort.insertionSort(arr);
		} else {
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}
	
	/**
	 * 假设数组的两段分别有序，left、right、mid为下标（起始、中间和末尾），第一段left至mid含mid。
	 * 第二段mid至right不含mid（即mid + 1至末尾），将两段合并为一个整体有序的数组。
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 */
	private static void merge(int[] arr, int left, int mid, int right) {
		int leftLength = mid - left + 1;
		int rightLength = right - mid;
		int[] leftArr = new int[leftLength]; //左段
		int[] rightArr = new int[rightLength]; //右段
		//拷贝到新数组，但准备通过比较再拷贝回去
		for(int i = 0; i < leftLength; i++) {
			leftArr[i] = arr[left + i];
		}
		//拷贝
		for(int i = 0; i < rightLength; i++) {
			rightArr[i] = arr[mid + i + 1];
		}
		//比较并按大小抓取到arr中
		int i = 0;
		int j = 0;
		for(int k = left; k < right + 1; k++) {
			if(leftLength == i && j < rightLength) {
				arr[k] = rightArr[j];
				j++;
				continue;
			}
			if(rightLength == j && i < leftLength) {
				arr[k] = leftArr[i];
				i++;
				continue;
			}
			if(leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = Util.getRandomArr(20, 1, 100);
		int[] arr2 = Util.getRandomArr(10, 1, 100);
		System.out.println("begin..." + Arrays.toString(arr1));
		mergeSort(arr1);
		System.out.println("final..." + Arrays.toString(arr1));
		System.out.println("begin..." + Arrays.toString(arr2));
		mergeSort(arr2);
		System.out.println("final..." + Arrays.toString(arr2));
	}
}
