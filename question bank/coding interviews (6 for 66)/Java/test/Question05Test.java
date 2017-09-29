package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question05Test {

    @Test
    public void test() {
        
        Question05 instance = new Question05();
        
        int[] answer = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] result = new int[answer.length];
        
        // 测试：先进6个，出3个，再进4个，出剩下的7个
        for (int i = 1; i <= 6; i++) {
            instance.push(i);            
        }
        for (int i = 1; i <= 3; i++) {
            result[i - 1] = instance.pop();
        }
        for (int i = 7; i <= 10; i++) {
            instance.push(i);
        }
        for (int i = 4; i <= 10; i++) {
            result[i - 1] = instance.pop();
        }
        
        assertArrayEquals(result, answer);
        
    }

}
