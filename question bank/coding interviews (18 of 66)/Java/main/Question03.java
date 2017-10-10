package org.logwing.harvey.questionbank.codinginterviews;

import java.util.ArrayList;

import org.logwing.harvey.questionbank.helper.ListNode;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * @author Harvey
 *
 */
public class Question03 {
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    /**
     * 递归。
     * @param listNode
     * @return 反向链表
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}