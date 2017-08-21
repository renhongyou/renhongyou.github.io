package questions.cc150._02linkedlist;

import org.lanqiao.study.datastructure.LinkedList;

/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。<br/>
 * 示例<br/>
 * 输入：单向链表 a -> b -> c -> d -> e 中的结点c。<br/>
 * 输出：不返回任何数据，但该链表变为：a -> b -> d -> e。
 * @author 任宏友
 *
 */
public class Question03 {
	/*
	 * 删除单向链表中间的某个结点，且只访问该结点。
	 * 首先将下一个结点赋给本结点，相当于删除了这个结点。
	 * 此时链表中出现了重复的结点，需要将此时结点的next指向原本下一个结点的next。
	 */
//	public boolean removeLinkedListNodeOnBody(LinkedListNode node) {
//		if(null == node || null == node.next) {
//			return false;
//		}
//		LinkedListNode nodeNext = node.next;
//		node.data = nodeNext.data;
//		node.next = nodeNext.next;
//		return true;
//	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		LinkedList<String> testList = new LinkedList<String>();
		testList.add("a");
		testList.add("b");
		testList.add("c");
		testList.add("d");
		testList.add("e");
		
		System.out.println(testList.toString());
		System.out.println(testList.removeLinkedListNodeOnBody(
				(LinkedList<String>.LinkedListNode<Object>) testList.getLinkedListNode("c")));
		System.out.println(testList.toString());
	}
}
