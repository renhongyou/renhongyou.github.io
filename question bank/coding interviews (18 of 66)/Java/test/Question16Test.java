package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;
import org.logwing.harvey.questionbank.helper.ListNode;

public class Question16Test {

    @Test
    public void test() {

        Question16 instance = new Question16();
        
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(5); 
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(5);
        list2.next.next.next = new ListNode(5);
        list2.next.next.next.next = new ListNode(8); 
        
        ListNode result = instance.Merge(list1, list2);
        
        int[] test = new int[10];
        int[] answer = { 1, 2, 2, 3, 3, 4, 5, 5, 5, 8 };
        
        int i = 1;
        test[0] = result.val;
        while (result.next != null) {
            test[i] = result.next.val;
            result = result.next;
            i++;
        }
        
        assertArrayEquals(test, answer);
        
    }

}
