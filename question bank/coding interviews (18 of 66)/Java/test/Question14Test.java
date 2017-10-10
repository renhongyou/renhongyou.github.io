package org.logwing.harvey.questionbank.codinginterviews;

import org.junit.Test;
import org.logwing.harvey.questionbank.helper.ListNode;

public class Question14Test {

    @Test
    public void test() {
        
        Question14 instance = new Question14();
        
        ListNode listNode = null;
        listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5); 
        
        int k = 4;
        int result = 2;
        int resultNull = 6;
        
        assert(instance.FindKthToTail01(listNode, k).val == result);
        assert(instance.FindKthToTail01(listNode, resultNull) == null);
        assert(instance.FindKthToTail02(listNode, k).val == result);
        assert(instance.FindKthToTail02(listNode, resultNull) == null);
        
    }

}
