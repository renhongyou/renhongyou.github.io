package org.lanqiao.study.sorts;

import java.util.Arrays;

import org.lanqiao.study.util.Util;

/**
 * 计数排序
 * 平均时间复杂度：O(n + k) 稳定
 * 空间复杂度：O(k)
 * 算法思想：
 * 1. 找出待排序的数组中最大和最小的元素；
 * 2. 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 3. 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 4. 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 * @author 任宏友
 *
 */
public class CountingSort {
	public static int[] countingSort(int[] arr) {
		arr = countingSort(arr, 0, arr.length - 1);
		return arr;
	}

	private static int[] countingSort(int[] arr, int left, int right) {
		int[] tem = new int[right + 1];
		int max = arr[left];
		int min = arr[left];
		for(int i : arr) {
			if(i > max) {
				max = i;
			}
			if(i < min) {
				min = i;
			}
		}
		//要排序的数组中，元素大小的极值差+1
		int k = max - min + 1;
		int[] count = new int[k];
		for(int i = 0; i <= right; ++i) {
			//尽量减小数组count的大小
			count[arr[i] - min] += 1;
		}
		for(int i = 1; i < count.length; ++i) {
			count[i] = count[i] + count[i - 1];
		}
		for(int i = right; i >= 0; --i) {
			//按照存取的方式取出count的元素
			tem[--count[arr[i] - min]] = arr[i];
		}
		return tem;
	}
	
	public static void main(String[] args) {
		int[] arr = Util.getRandomArr(20, 1, 100);
		System.out.println("begin..." + Arrays.toString(arr));
		System.out.println("final..." + Arrays.toString(countingSort(arr)));
	}
}
