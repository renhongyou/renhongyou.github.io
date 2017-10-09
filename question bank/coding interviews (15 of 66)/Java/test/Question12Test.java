package org.logwing.harvey.questionbank.codinginterviews;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Question12Test {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    
    @Test
    public void test() {

        Question12 instance = new Question12();
        
        assert(instance.power(0.0, 0) == 1);
        assert(instance.power(-1, -1) == -1);
        assert(instance.power(2, 10) == 1024);
        
        expectedEx.expect(RuntimeException.class);
        instance.power(0.0, -2);
        
    }

}
