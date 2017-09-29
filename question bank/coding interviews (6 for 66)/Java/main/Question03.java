package org.logwing.harvey.questionbank.codinginterviews;

import java.util.ArrayList;

class ListNode {
    public int val;
    public ListNode next = null;
    
    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * @author Harvey
 *
 */
public class Question03 {
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    /**
     * 思路：递归。
     * @param listNode
     * @return 反向链表
     */
    public ArrayList<Integer> solution(ListNode listNode) {
        if (listNode != null) {
            this.solution(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}