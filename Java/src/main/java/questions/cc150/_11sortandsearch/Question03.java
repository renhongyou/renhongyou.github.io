package questions.cc150._11sortandsearch;

/**
 * 给定一个排序后的数组，包含n个整数，但这个数组已经被旋转很多次，次数不详。<br/>
 * 请编写代码找出数组中的某个元素，可以假定数组元素原先是按照从小到大的顺序排列的。<br/>
 * 示例<br/>
 * 输入：在数组{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}中找出5。<br/>
 * 输出：8（元素5在该数组中的索引）。
 * @author 任宏友
 *
 */
public class Question03 {
	private static int searchRotationArray(int arr[], int left, int right, int key) {
		int mid = (left + right) / 2;
		if(key == arr[mid]) {
			//直接查找整个数列的中点
			return mid;
		}
		if(right < left) {
			return -1;
		}
		/*
		 * 由于数组旋转可能会产生一个拐点，拐点左边和右边的部分一定都是正常排序的。
		 * 我们可以分别观察左右两半来判断应该从哪半边展开搜索。
		 */
		if(arr[left] < arr[mid]) {
			//左半部分是正常排序的
			if(key >= arr[left] && key <= arr[mid]) {
				return searchRotationArray(arr, left, mid - 1, key);
			} else {
				return searchRotationArray(arr, mid + 1, right, key);
			}
		} else if(arr[left] > arr[mid]) {
			//右半部分是正常排序的
			if(key >= arr[mid] && key <= arr[right]) {
				return searchRotationArray(arr, mid + 1, right, key);
			} else {
				return searchRotationArray(arr, left, mid - 1, key);
			}
		} else if(arr[left] == arr[mid]) {
			//左半部分是所有元素相等或者右半部分所有元素相等
			if(arr[mid] != arr[right]) {
				//如果右半部分数据不同，则搜索右半部分
				return searchRotationArray(arr, mid + 1, right, key);
			} else {
				//如果不是上述情况，那么两边都查找
				int rst = searchRotationArray(arr, left, mid - 1, key);
				if(rst == -1) {
					return searchRotationArray(arr, mid + 1, right, key);
				} else {
					return rst;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] testArray = {2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2};
		System.out.println(searchRotationArray(testArray, 0, 12, 3));
	}
}
