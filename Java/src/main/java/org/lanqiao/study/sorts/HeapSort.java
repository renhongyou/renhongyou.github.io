package org.lanqiao.study.sorts;

import java.util.Arrays;

import org.lanqiao.study.util.Util;

/**
 * 堆排序
 * 平均时间复杂度：O(nlgn) 不稳定
 * 空间复杂度：O(1)
 * 算法思想：
 * 1. 将初始待排序关键字序列(R1, R2, ..., Rn)构建成大顶堆，此堆为初始的无序区；
 * 2. 将堆顶元素R[1]与最后一个元素R[n]交换，
 * 此时得到新的无序区(R1, R2, ..., Rn - 1)和新的有序区(Rn)，且满足R[1, 2 , ..., n - 1] <= R[n]；
 * 3. 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1, R2, ..., Rn - 1)调整为新堆，
 * 然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1, R2, ..., Rn - 2)和新的有序区(Rn - 1, Rn)。
 * 不断重复此过程直到有序区的元素个数为n - 1，则整个排序过程完成。
 * @author 任宏友
 *
 */
public class HeapSort {
	public static void heapSort(int[] arr) {
		buildMaxHeapify(arr);
		heapSort(arr, 0, arr.length - 1);
		printTree(arr);
	}
	
	private static void buildMaxHeapify(int[] arr) {
		//没有子节点的才需要创建最大堆，从最后一个的父节点开始
		int startIndex = getParentIndex(arr.length - 1);
		//从尾端开始创建最大堆，每次都是正确的堆
		for(int i = startIndex; i >= 0; i--) {
			maxHeapify(arr, arr.length, i);
		}
	}
	
	/**
	 * 创建最大堆
	 * @param arr
	 * @param heapSize 需要创建的最大堆的大小
	 * @param index 当前需要创建最大堆的位置
	 */
	private static void maxHeapify(int[] arr, int heapSize, int index) {
		//当前节点与左右子节点比较
		int left = getLeftChildIndex(index);
		int right = getRightChildIndex(index);
		int largest = index;
		if(left < heapSize && arr[index] < arr[left]) {
			largest = left;
		}
		if(right < heapSize && arr[largest] < arr[right]) {
			largest = right;
		}
		//得到最大值之后可能需要交换，如果交换，其子节点将不是最大堆，需要重新调整
		if(largest != index) {
			Util.swap(arr, index, largest);
			maxHeapify(arr, heapSize, largest);
		}
	}

	/**
	 * 排序，最大值放于末尾，调整最大堆
	 * @param arr
	 * @param left
	 * @param right
	 */
	private static void heapSort(int[] arr, int left, int right) {
		if(null == arr || left == right) {
			return;
		}
		//末尾与头交换，交换后调整最大堆
		for(int i = right; i > 0; i--) {
			Util.swap(arr, 0, i);
			maxHeapify(arr, i, 0);
		}
	}
	
	/**
	 * 父节点位置
	 * @param index
	 * @return
	 */
	private static int getParentIndex(int index) {
		return (index - 1) >> 1;
	}
	
	/**
	 * 左子节点位置
	 * @param index
	 * @return
	 */
	private static int getLeftChildIndex(int index) {
		return (index << 1) + 1;
	}
	
	/**
	 * 右子节点位置
	 * @param index
	 * @return
	 */
	private static int getRightChildIndex(int index) {
		return (index << 1) + 2;
	}
	
	/**
	 * 打印堆
	 * @param arr
	 */
	private static void printTree(int[] arr) {
		int pre = -2;
		for(int i = 0; i < arr.length; i++) {
			if(pre < getLog(i + 1)) {
				pre = getLog(i + 1);
				System.out.println();
			}
			System.out.print(arr[i] + " | ");
		}
		System.out.println();
	}
	
	/**
	 * 获取以2为底的对数
	 * @param d
	 * @return
	 */
	private static int getLog(double d) {
		return (int) (Math.log(d) / Math.log(2));
	}
	
	public static void main(String[] args) {
		int[] arr = Util.getRandomArr(20, 1, 100);
		System.out.println("begin..." + Arrays.toString(arr));
		heapSort(arr);
		System.out.println("final..." + Arrays.toString(arr));
	}
}
