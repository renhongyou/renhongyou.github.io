package org.logwing.harvey.questionbank.codinginterviews;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author Harvey
 *
 */
public class Question11 {
    /**
     * API直接求解。
     * @param n
     * @return number of 1 in binary
     */
    public int numberOf1_01(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }
    
    /**
     * API直接求解。
     * @param n
     * @return number of 1 in binary
     */
    public int numberOf1_02(int n) {
        return Integer.bitCount(n);
    }
    
    /**
     * 不考虑API，考虑底层位运算实现。<br>
     * 如果一个整数不为0，那么这个整数至少有一位是1。<br>
     * 如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0（如果有）都会变成1。<br>
     * 其余所有位将不会受到影响。
     * @param n
     * @return number of 1 in binary
     */
    public int numberOf1_03(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
