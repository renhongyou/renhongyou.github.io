package org.logwing.harvey.questionbank.codinginterviews;

import org.logwing.harvey.questionbank.helper.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author Harvey
 *
 */
public class Question14 {
    /**
     * 两指针都从链表头开始进行一次遍历。<br>
     * helper先跑，并且记录节点数，当helper跑了k - 1个节点后，target开始跑。<br>
     * 当helper跑到最后时，target所指向的就是倒数第k个节点。<br>
     * 同时考虑如果节点个数小于k，则返回空。
     * @param head
     * @param k
     * @return the Kth to tail
     */
    public ListNode FindKthToTail01(ListNode head, int k) {
        ListNode target = head;
        ListNode helper = head;
        int a = k;
        int count = 0;
        
        while (helper != null) {
            helper = helper.next;
            count++;
            if (k < 1) {
                target = target.next;
            }
            k--;
        }
        
        if (count < a) {
            return null;
        }
        return target;
    }
    
    /**
     * 代码精简版，但效率不变。
     * @param head
     * @param k
     * @return the Kth to tail
     */
    public ListNode FindKthToTail02(ListNode head, int k) {
        ListNode target = head;
        ListNode helper = head;
        int i = 0;
        
        for (; helper != null; i++) {
            if (i >= k) {
                target = target.next;
            }
            helper = helper.next;
        }
        
        return i < k ? null : target;
    }
}
