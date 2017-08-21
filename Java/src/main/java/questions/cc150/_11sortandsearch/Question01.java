package questions.cc150._11sortandsearch;

import java.util.Arrays;

/**
 * 给定两个排序后的数组A和B，其中A的末端有足够的缓冲空容纳B。<br/>
 * 编写一个方法，将B合并入A并排序。
 * @author 任宏友
 *
 */
public class Question01 {
	/**
	 * @param a 第一个数组
	 * @param b 第二个数组
	 * @param lastA a中包含的“真实”元素个数
	 * @param lastB a中包含的“真实”元素个数
	 * @return
	 */
	private static void sortAaddB(int[] a, int[] b, int lastA, int lastB) {
		int indexMerged = lastB + lastA - 1; //排序后末尾元素索引
		int indexA = lastA - 1; //b数组末尾元素索引
		int indexB = lastB - 1; //a数组末尾元素索引
		//归并a和b，从最末尾的元素开始
		while(indexB >= 0) {
			if(indexA >= 0 && a[indexA] > b[indexB]) {	
				//a末尾的元素比b末尾的元素来得大
				a[indexMerged] = a[indexA];
				indexA--;
			} else {
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--;
		}
	}
	public static void main(String[] args) {
		int[] a = {0, 2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] b = {1, 4, 7, 6, 100, 1000};
		sortAaddB(a, b, 9, 6);
		System.out.println(Arrays.toString(a));
	}
}
