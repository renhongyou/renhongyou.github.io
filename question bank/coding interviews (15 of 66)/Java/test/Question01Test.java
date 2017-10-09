package org.logwing.harvey.questionbank.codinginterviews;

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
        
        assert(instance.find01(array, target));
        assert(instance.find02(array, target));
        
        assert(!instance.find01(arrayEmpty, target));
        assert(!instance.find02(arrayEmpty, target));
        
        assert(!instance.find01(arrayNull, target));
        assert(!instance.find02(arrayNull, target));
        
    }

}
