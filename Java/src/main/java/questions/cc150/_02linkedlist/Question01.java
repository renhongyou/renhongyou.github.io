package questions.cc150._02linkedlist;

import org.lanqiao.study.datastructure.LinkedList;

/**
 * 编写代码，移除未排序链表中的重复结点。<br/>
 * 进阶<br/>
 * 如果不得使用临时缓冲区，该怎么解决？
 * @author 任宏友
 *
 */
public class Question01 {
	/*
	 * 移除重复结点，需要知道哪些结点是重复的。
	 * 考虑利用一个哈希表，如果有重复的元素，则将该元素从链表里删除，然后继续迭代。
	 */
//public void deleteRepeatElement(LinkedListNode node) {
//		LinkedListNode previous = null;
//		Hashtable<Object, Boolean> table = new Hashtable<Object, Boolean>();
//		while(null != node) {
//			if(table.containsKey(node.getData())) {
//				previous.setNext(node.getNext());
//			} else {
//				table.put(node.getData(), true);
//				previous = node;
//			}
//			node = node.getNext();
//		}
//	}
	
	/*
	 * 进阶：不使用缓冲区。
	 * 用两个指针，一个current迭代地访问整个链表，一个runner用于检查每个current后续结点是否重复。
	 * 此举平均时间复杂度为O(n^2)，空间复杂度为O(1)。
	 */
//public void deleteRepeatElementWithoutUseBuffer(LinkedListNode node) {
//		if(null == head) {
//			return;
//		}
//		LinkedListNode current = head;
//		while(null != current) {
//			LinkedListNode runner = current;
//			while(null != runner.next) {
//				if(runner.next.data == current.data) {
//					runner.next = runner.next.next;
//				} else {
//					runner = runner.next;
//				}
//			}
//			current = current.next;
//		}
//	}
	
	public static void main(String[] args) {
		LinkedList<Integer> testList = new LinkedList<Integer>();
		LinkedList<Integer> temp = new LinkedList<Integer>();
		testList.add(5);
		testList.add(1);
		testList.add(4);
		testList.add(4);
		testList.add(5);
		testList.add(9);
		testList.add(7);
		testList.add(13);
		testList.add(3);
		temp = testList;
		
		System.out.println(testList.toString());
		testList.deleteRepeatElement(testList.getLinkedListNode(0));
		System.out.println(testList.toString());
		temp.deleteRepeatElementWithoutUseBuffer(testList.getLinkedListNode(0));
		System.out.println(temp.toString());
	}
}
