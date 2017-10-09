package org.logwing.harvey.questionbank.codinginterviews;

import static org.junit.Assert.*;

import org.junit.Test;
import org.logwing.harvey.questionbank.helper.ListNode;

public class Question15Test {

    @Test
    public void test() {
        
        Question15 instance = new Question15();

        ListNode listNode01 = null;
        ListNode listNode02 = null;
        
        assert(instance.ReverseList01(listNode01) == null);
        assert(instance.ReverseList02(listNode02) == null);
        
        listNode01 = new ListNode(1);
        listNode02 = new ListNode(1);
        
        assert(instance.ReverseList01(listNode01).val == 1);
        assert(instance.ReverseList02(listNode02).val == 1);
        
        listNode01.next = new ListNode(2);
        listNode01.next.next = new ListNode(3);
        listNode01.next.next.next = new ListNode(4);
        listNode01.next.next.next.next = new ListNode(5); 
        listNode02.next = new ListNode(2);
        listNode02.next.next = new ListNode(3);
        listNode02.next.next.next = new ListNode(4);
        listNode02.next.next.next.next = new ListNode(5); 
        
        ListNode head01 = instance.ReverseList01(listNode01);
        ListNode head02 = instance.ReverseList02(listNode02);
        int[] reverse01 = { head01.val, head01.next.val, head01.next.next.val, 
                head01.next.next.next.val, head01.next.next.next.next.val };
        int[] reverse02 = { head02.val, head02.next.val, head02.next.next.val, 
                head02.next.next.next.val, head02.next.next.next.next.val };
        int[] result = { 5, 4, 3, 2, 1 };
        
        assertArrayEquals(reverse01, result);
        assertArrayEquals(reverse02, result);
        
    }

}
