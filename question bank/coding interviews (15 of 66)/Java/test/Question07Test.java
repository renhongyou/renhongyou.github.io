package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question07Test {

    @Test
    public void test() {
        
        Question07 instance = new Question07();
        
        for (int i = 0; i <= 39; i++) {
            assertEquals(instance.Fibonacci01(i), instance.Fibonacci02(i));
            assertEquals(instance.Fibonacci01(i), instance.Fibonacci03(i));
        }
        
    }

}
