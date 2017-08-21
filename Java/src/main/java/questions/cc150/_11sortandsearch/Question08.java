package questions.cc150._11sortandsearch;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字x的秩（小于或等于x的值的数目）。<br/>
 * 请实现数据结构和算法支持这些操作，也就是说，实现track(int x)方法，每读入一个数字都会调用该方法；<br/>
 * 以及getRankOfNumber(int x)方法，返回值为小于或等于x的元素个数（不包括x本身）。<br/>
 * 示例<br/>
 * 数据流为（按出现的先后顺序）：5, 1, 4, 4, 5, 9, 7, 13, 3<br/>
 * getRankOfNumber(1) = 0<br/>
 * getRankOfNumber(3) = 1<br/>
 * getRankOfNumber(4) = 3
 * @author 任宏友
 *
 */
public class Question08 {
    private static int[] getRankOfNumber(int[] arr, int n) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            Iterator<Integer> it = list.iterator();
            int j = 0;
            while(it.hasNext()) {
                if(it.next() > arr[i]) {
                    break;
                }
                j++;
            }
            res[i] = j;
            list.add(j, arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
		int[] arr = {5, 1, 4, 4, 5, 9, 7, 13, 3};
		int[] rank = getRankOfNumber(arr, arr.length);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(rank));
	}
}