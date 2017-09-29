package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question02Test {

    @Test
    public void test() {

        Question02 instance = new Question02();
        
        StringBuffer str = new StringBuffer("hello world");
        String result = "hello%20world";
        
        assertEquals(result, instance.solution01(str));
        assertEquals(result, instance.solution02(str));
        
        str = new StringBuffer("");
        result = "";
        
        assertEquals(result, instance.solution01(str));
        assertEquals(result, instance.solution02(str));
        
        str = null;
        result = null;
        
        assertEquals(result, instance.solution01(str));
        assertEquals(result, instance.solution02(str));
        
    }

}
