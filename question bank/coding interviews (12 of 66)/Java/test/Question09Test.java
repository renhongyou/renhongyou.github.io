package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question09Test {

    @Test
    public void test() {
        
        Question09 instance = new Question09();
        
        for (int i = 0; i <= 31; i++) {
            assertEquals(instance.jumpFloorII01(i), instance.jumpFloorII02(i));
            assertEquals(instance.jumpFloorII01(i), instance.jumpFloorII03(i));
        }
        
    }

}
