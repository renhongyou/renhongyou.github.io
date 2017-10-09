package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question13Test {

    @Test
    public void test() {
        
        Question13 instance = new Question13();
        
        int[] array = { 1, 2, 3, 4, 5, 6, 12, 8, 11 };
        int[] arrayEmpty = {};
        int[] arrayNull = null;
        int[] result = { 1, 3, 5, 11, 2, 4, 6, 12, 8 };
        int[] resultEmpty = {};
        int[] resultNull = null;
        
        instance.reOrderArray(array);
        instance.reOrderArray(arrayEmpty);
        instance.reOrderArray(arrayNull);
        
        assertArrayEquals(array, result);
        assertArrayEquals(arrayEmpty, resultEmpty);
        assertArrayEquals(arrayNull, resultNull);
        
    }

}
