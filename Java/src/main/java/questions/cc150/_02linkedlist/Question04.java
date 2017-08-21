package questions.cc150._02linkedlist;

import org.lanqiao.study.datastructure.LinkedList;

/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前。
 * @author 任宏友
 *
 */
public class Question04 {
	/**
	 * 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前。
	 * 可以考虑创建两个链表，一个储存小于x的结点，一个储存大于x的结点，最后连接两个链表。
	 * @param node
	 * @param x
	 * @return
	 */
//	public LinkedListNode partitionLinkedList(LinkedListNode node, Object x) {
//		LinkedListNode beforeHead = null;
//		LinkedListNode beforeTail = null;
//		LinkedListNode afterHead = null;
//		LinkedListNode afterTail = null;
//		while(null != node) {
//			LinkedListNode next = node.next;
//			node.next = null;
//			if(node.compareTo(x) < 0) {
//				if(null == beforeHead) {
//					beforeHead = node;
//					beforeTail = beforeHead;
//				} else {
//					beforeTail.next = node;
//					beforeTail = node;
//				}
//			} else {
//				if(null == afterHead) {
//					afterHead = node;
//					afterTail = afterHead;
//				} else {
//					afterTail.next = node;
//					afterTail = node;
//				}
//			}
//			node = next;
//		}
//		if(null == beforeHead) {
//			return afterHead;
//		}
//		beforeTail.next = afterHead;
//		return beforeHead;
//	}

	public static void main(String[] args) {
		LinkedList<Integer> testList = new LinkedList<Integer>();
		testList.add(5);
		testList.add(1);
		testList.add(4);
		testList.add(4);
		testList.add(5);
		testList.add(9);
		testList.add(7);
		testList.add(13);
		testList.add(3);
		System.out.println(testList);
		System.out.println(testList.toString(testList.partitionLinkedList(testList.getHead(), 2)));
	}
}
