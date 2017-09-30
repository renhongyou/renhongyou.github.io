package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question11Test {

    @Test
    public void test() {

        Question11 instance = new Question11();
        
        for (int i = -1024; i <= 1024; i++) {
            assertEquals(instance.numberOf1_01(i), instance.numberOf1_02(i));
            assertEquals(instance.numberOf1_01(i), instance.numberOf1_03(i));
        }
        
    }

}
