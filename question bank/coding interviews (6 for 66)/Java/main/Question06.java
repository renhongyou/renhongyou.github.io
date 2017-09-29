package org.logwing.harvey.questionbank.codinginterviews;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 <br>
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。<br>
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。<br>
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author Harvey
 *
 */
public class Question06 {
    /**
     * 思路：<br>
     * 由于数组是非递减排序，所以可能存在重复的情况，此时使用变相二分查找解题会不严谨。<br>
     * 顺序遍历数组，寻找分界点，分界点前后都是非递减数组，考虑后一个数比前一个数小的可能性：<br>
     * 如果出现，这个数就是最小值；<br>
     * 如果没有出现，说明这个数组所有的数都相等，返回数组首位即可。<br>
     * 数组为空，则返回0。
     * @param array
     * @return min or 0
     */
    public int result(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else {
                if (i == array.length - 2) {
                    return array[0];
                }
            }
        }
        return 0;
    }
}
