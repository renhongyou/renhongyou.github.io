package questions.cc150._02linkedlist;

import org.lanqiao.study.datastructure.LinkedList;

/**
 * 实现一个算法，找出单向链表中倒数第k个结点。
 * @author 任宏友
 *
 */
public class Question02 {
	/*
	 * 迭代法。使用两个指针point1和point2，将它们指向链表中相距k个结点的两个结点。
	 * 将point1和point2指向链表头，然后将point2向后移动k个结点。
	 * 之后，我们以相同的速度移动两个指针。
	 * point2会在移动length - k步之后抵达链表尾，此时point1指向所求的链表的倒数第k个结点。
	 */
//	public LinkedListNode kFromTail(LinkedListNode head, int k) {
//		if(k <= 0) {
//			return null;
//		}
//		LinkedListNode point1 = head;
//		LinkedListNode point2 = head;
//		
//		for(int i = 0; i < k - 1; i++) {
//			if(null == point2) {
//				return null;
//			}
//			point2 = point2.next;
//		}
//		if(null == point2) {
//			return null;
//		}
//		while(null != point2.next) {
//			point1 = point1.next;
//			point2 = point2.next;
//		}
//		return point1;
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
		
		System.out.println(testList.kFromTail(4).getData());
	}
}
