package org.logwing.harvey.questionbank.codinginterviews;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author Harvey
 *
 */
public class Question12 {
    /**
     * 全面考察指数的正负、底数是否为0的情况。
     * @param base
     * @param exponent
     * @return base^exponent
     */
    public double power(double base, int exponent) {
        double result = 1;
        double current = base;
        int n;
        if (exponent > 0) {
            n = exponent;
        } else if (exponent < 0) {
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
        return exponent > 0 ? result : (1 / result);
    }
}
