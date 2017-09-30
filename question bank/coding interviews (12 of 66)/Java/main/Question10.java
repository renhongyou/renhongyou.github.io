package org.logwing.harvey.questionbank.codinginterviews;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author Harvey
 *
 */
public class Question10 {
    /**
     * 与第8题完全一样的思路，本质上还是求斐波那契数列。
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int fibonacci1 = 0;
        int fibonacci2 = 1;
        int value = 1;
        for (int i = 1; i <= target; ++i) {
            value = fibonacci1 + fibonacci2;
            fibonacci1 = fibonacci2;
            fibonacci2 = value;
        }
        return value;
    }
}
