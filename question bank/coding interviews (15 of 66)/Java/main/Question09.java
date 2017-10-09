package org.logwing.harvey.questionbank.codinginterviews;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。（n<=31）
 * @author Harvey
 *
 */
public class Question09 {
    /**
     * 一行代码可解决。
     * @param target
     * @return value
     */
    public int jumpFloorII01(int target) {
        return  (target <= 0 || target > 31) ? 0 : (1 << --target);        
    }
    
    /**
     * 递归。
     * @param target
     * @return value
     */
    public int jumpFloorII02(int target) {
        if (target <= 0 || target > 31) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * jumpFloorII02(target - 1);
        }
    }
    
    /**
     * 迭代。
     * @param target
     * @return value
     */
    public int jumpFloorII03(int target) {
        if (target <= 0 || target > 31) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int a = 1;
        int b = 2;
        for (int i = 2; i <= target; i++) {
            b = 2 * a;
            a = b;
        }
        return b;
    }
}
