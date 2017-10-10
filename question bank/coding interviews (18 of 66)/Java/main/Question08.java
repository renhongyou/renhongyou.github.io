package org.logwing.harvey.questionbank.codinginterviews;

import java.math.BigInteger;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author Harvey
 *
 */
public class Question08 {
    /**
     * 思路：本质上是求大数的斐波那契数列。
     * @param target
     * @return BigInteger
     */
    public BigInteger jumpFloor(int target) {
        if (target <= 0) {
            return new BigInteger("0");
        }
        if (target == 1) {
            return new BigInteger("1");
        }
        BigInteger fibonacci1 = new BigInteger("0");
        BigInteger fibonacci2 = new BigInteger("1");
        BigInteger value = new BigInteger("1");
        for (int i = 1; i <= target; ++i) {
            value = fibonacci1.add(fibonacci2);
            fibonacci1 = fibonacci2;
            fibonacci2 = value;
        }
        return value;
    }        
}
