package org.logwing.harvey.questionbank.codinginterviews;

import org.logwing.harvey.questionbank.helper.ListNode;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * @author Harvey
 *
 */
public class Question15 {
    /**
     * 循环。
     * @param head
     * @return new head
     */
    public ListNode ReverseList01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pre = null;
        ListNode next = null;
        
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    /**
     * 递归。
     * @param head
     * @return new head
     */
    public ListNode ReverseList02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pre = ReverseList02(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return pre;
    }
}
