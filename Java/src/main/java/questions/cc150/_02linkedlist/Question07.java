package questions.cc150._02linkedlist;

import org.lanqiao.study.datastructure.LinkedList;

/**
 * 编写一个函数，检查链表是否为回文。
 * @author 任宏友
 *
 */
public class Question07 {
	/**
	 * 递归求解。
	 * @author 任宏友
	 *
	 */
//	public class Result {
//		public LinkedListNode node;
//	    public boolean result;
//	    public Result(LinkedListNode node, boolean result) {
//	    	super();
//	    	this.node = node;
//	    	this.result = result;
//	    }
//	}
//	public Result isPalindromeRecurse(LinkedListNode head, int length) {
//	    if (null == head || 0 == length) {
//	        return new Result(null, true);
//	    }
//	    else if(1 == length) {
//	        return new Result(head.next, true);
//	    }
//	    else if(2 == length) {
//	        return new Result(head.next.next, head.data == head.next.data);
//	    }
//	    Result rst = isPalindromeRecurse(head.next, length - 2);
//	    if(!rst.result || null == rst.node) {
//	        return rst;
//	    }
//	    else{
//	    	rst.result = (head.data == rst.node.data);
//	    	rst.node = rst.node.next;
//	        return rst;
//	    }
//	}
//	public boolean isPalinddrome(LinkedList list) {
//	    Result p = isPalindromeRecurse(list.getHead(), list.size());
//	    return p.result;
//	}
	
	public static void main(String[] args) {
		LinkedList<String> testListTrue = new LinkedList<String>();
		testListTrue.add("A");
		testListTrue.add("B");
		testListTrue.add("C");
		testListTrue.add("C");
		testListTrue.add("B");
		testListTrue.add("A");
		LinkedList<String> testListFalse = new LinkedList<String>();
		testListFalse.add("A");
		testListFalse.add("B");
		testListFalse.add("C");
		testListFalse.add("D");
		testListFalse.add("E");
		
		System.out.println(testListTrue.toString());
		System.out.println(testListTrue.isPalinddrome(testListTrue));
		System.out.println(testListFalse.toString());
		System.out.println(testListFalse.isPalinddrome(testListFalse));
	}
}
