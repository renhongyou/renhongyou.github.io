package org.logwing.harvey.questionbank.codinginterviews;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。（n<=39）
 * @author Harvey
 *
 */
public class Question07 {
    /**
     * 暴力破解。
     * @param n
     * @return value
     */
    public int Fibonacci01(int n) {
        int[] fibonacci = {
                0,          // <= 0 || >39
                1,          // 1
                1,          // 2
                2,          // 3
                3,          // 4
                5,          // 5
                8,          // 6
                13,         // 7
                21,         // 8
                34,         // 9
                55,         // 10
                89,         // 11
                144,        // 12
                233,        // 13
                377,        // 14
                610,        // 15
                987,        // 16
                1597,       // 17
                2584,       // 18
                4181,       // 19
                6765,       // 20
                10946,      // 21
                17711,      // 22
                28657,      // 23
                46368,      // 24
                75025,      // 25
                121393,     // 26
                196418,     // 27
                317811,     // 28
                514229,     // 29
                832040,     // 30
                1346269,    // 31
                2178309,    // 32
                3524578,    // 33
                5702887,    // 34
                9227465,    // 35
                14930352,   // 36
                24157817,   // 37
                39088169,   // 38
                63245986    // 39
        };
        return (n <= 0 || n > 39) ? fibonacci[0] : fibonacci[n];
    }

    /**
     * 递归。
     * @param n
     * @return value
     */
    public int Fibonacci02(int n) {
        return (n <= 0 || n > 39) ? 
                0 : (n <= 2 ? 1 : Fibonacci02(n - 1) + Fibonacci02(n - 2));
    }
    
    /**
     * 迭代。
     * @param n
     * @return value
     */
    public int Fibonacci03(int n) {
        if (n <= 0 || n > 39) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fibonacci1 = 0;
        int fibonacci2 = 1;
        int value = 0;
        for (int i = 2; i <= n; ++i) {
            value = fibonacci1 + fibonacci2;
            fibonacci1 = fibonacci2;
            fibonacci2 = value;
        }
        return value;
    }
}
