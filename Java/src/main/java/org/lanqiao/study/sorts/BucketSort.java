package org.lanqiao.study.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.lanqiao.study.util.Util;

/**
 * 桶排序
 * 平均时间复杂度：O(n + k) 稳定
 * 空间复杂度：O(n + k)
 * 算法思想：
 * 1. 设置一个定量的数组当作空桶；
 * 2. 遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 3. 对每个不是空的桶进行排序；
 * 4. 从不是空的桶里把排好序的数据拼接起来。
 * @author 任宏友
 *
 */
public class BucketSort {
	public static void bucketSort(int[] arr) {
		bucketSort(arr, 0, arr.length - 1);
	}

	private static void bucketSort(int[] arr, int left, int right) {
		//首先计算出数据中的最值
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= right; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		//桶的数量
		int bucketNum = (max - min) / (right + 1) + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for(int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}
		//将每一个元素都放入对应的桶
		for(int i = 0; i <= right; i++) {
			int num = (arr[i] - min) / (right + 1);
			bucketArr.get(num).add(arr[i]);
		} 
		//对每个桶进行排序
		for(int i = 0; i < bucketArr.size(); i++) {
			Collections.sort(bucketArr.get(i));
		}
		int index = 0;
		for(int i = 0; i < bucketArr.size(); i++) {
			for(int j = 0; j < bucketArr.get(i).size(); j++) {
				arr[index] = bucketArr.get(i).get(j);
				index++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = Util.getRandomArr(100, 1, 100);
		System.out.println("begin..." + Arrays.toString(arr));
		bucketSort(arr);
		System.out.println("final..." + Arrays.toString(arr));
	}
}
