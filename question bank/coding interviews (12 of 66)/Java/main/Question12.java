package org.logwing.harvey.questionbank.codinginterviews;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author Harvey
 *
 */
public class Question12 {
    /**
     * 
     * @param base
     * @param exponent
     * @return base^exponent
     */
    public double power(double base, int exponent) {
        double result = 1;
        double current = base;
        int n = exponent;
        if (n > 0) {
            n = exponent;
        } else if (n < 0) {
            if (base == 0) {
                throw new RuntimeException("分母为零");
            }
            n = -exponent;
        } else {
            return 1;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= current;
            }
            current *= current;
            n >>= 1;
        }
        return n > 0 ? result : (1 / result);
    }
}
