package org.logwing.harvey.questionbank.codinginterviews;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。<br>
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author Harvey
 *
 */
public class Question01 {
    /**
     * 思路一：<br>
     * 把每一行看成有序递增的数组，利用二分查找，通过遍历每一行得到答案，时间复杂度为nlogn。
     * @param array 二位整型数组
     * @param target 目标整数
     * @return true/false
     */
    public boolean solution01(int[][] array, int target) {
        if (array == null) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 思路二：<br>
     * 利用二维数组由上到下，由左到右递增的规律，选取右上角或者左下角的元素a[row][col]与target进行比较：<br>
     * 当target小于元素a[row][col]时，那么target必定在元素a所在行的左边，col--；<br>
     * 当target大于元素a[row][col]时，那么target必定在元素a所在列的下边，row++。
     * @param array 二位整型数组
     * @param target 目标整数
     * @return true/false
     */
    public boolean solution02(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
