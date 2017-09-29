package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question06Test {

    @Test
    public void test() {

        Question06 instance = new Question06();
        
        int[] array = { 3, 4, 5, 6, 2 };
        int[] arraySame = { 6, 6, 6, 6, 6 };
        int[] arrayEmpty = {};
        int[] arrayNull = null;
        
        assertEquals(2, instance.result(array));
        assertEquals(6, instance.result(arraySame));
        assertEquals(0, instance.result(arrayEmpty));
        assertEquals(0, instance.result(arrayNull));
    }

}
