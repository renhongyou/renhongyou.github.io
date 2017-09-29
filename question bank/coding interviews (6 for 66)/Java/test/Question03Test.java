package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Question03Test {
    
    @Test
    public void test() {
        
        Question03 instance = new Question03();
        
        ListNode listNode = null;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        assertEquals(result, instance.solution(listNode));

        listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        result = new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1));

        assertEquals(result, instance.solution(listNode));
        
    }

}
