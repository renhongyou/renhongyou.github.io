package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question01Test {

    @Test
    public void test() {

        Question01 instance = new Question01();
        
        int array[][] = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int arrayEmpty[][] = {};
        int arrayNull[][] = null;
        int target = 7;
        
        assertEquals(true, instance.solution01(array, target));
        assertEquals(true, instance.solution02(array, target));
        
        assertEquals(false, instance.solution01(arrayEmpty, target));
        assertEquals(false, instance.solution02(arrayEmpty, target));
        
        assertEquals(false, instance.solution01(arrayNull, target));
        assertEquals(false, instance.solution02(arrayNull, target));
        
    }

}
