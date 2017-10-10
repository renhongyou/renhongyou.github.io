package org.logwing.harvey.questionbank.codinginterviews;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。<br>
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author Harvey
 *
 */
public class Question02 {
    /**
     * 考虑API
     * @param str
     * @return result
     */
    public String replaceSpace01(StringBuffer str) {
        try {
            return str.toString().replaceAll(" ", "%20");
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    /**
     * 不考虑replaceAll，那么如何替换才更有效率：<br>
     * 从前往后替换，后面的字符需要不断往后移动，并且需要多次移动，效率低下；<br>
     * 从后往前，先计算需要多少空间，然后从后往前移动，每个字符只需要移动一次，效率相对较高。
     * @param str
     * @return result
     */
    public String replaceSpace02(StringBuffer str) {
        try {
            int spaceNum = 0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' ') {
                    spaceNum++;
                }
            }
            int indexBefore = str.length() - 1;
            int length = str.length() + spaceNum * 2;
            int indexAfter = length - 1;
            str.setLength(length);
            for (; indexBefore >= 0 && indexAfter < length; --indexBefore) {
                if (str.charAt(indexBefore) == ' ') {
                    str.setCharAt(indexAfter--, '0');
                    str.setCharAt(indexAfter--, '2');
                    str.setCharAt(indexAfter--, '%');
                } else {
                    str.setCharAt(indexAfter--, str.charAt(indexBefore));
                }
            }
            return str.toString();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
