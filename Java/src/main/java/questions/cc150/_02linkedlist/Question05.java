package questions.cc150._02linkedlist;

import org.lanqiao.study.datastructure.LinkedList;

/**
 * 给定两个用链表表示的整数，每个结点包含一个整数位。<br/>
 * 这些数位是反向存放的，也就是个位数排在链表首部。<br/>
 * 编写函数对这两个整数求和，并用链表形式返回结果。<br/>
 * 示例<br/>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295。<br/>
 * 输出：2 -> 1 -> 9，即912。<br/>
 * 进阶<br/>
 * 假设这些数位是正向存放的，请再做一遍。<br/>
 * 示例<br/>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295。<br/>
 * 输出：9 -> 1 -> 2，即912。<br/>
 * @author 任宏友
 *
 */
public class Question05 {
	/**
	 * 注意要避开空指针异常，如果两个数位数不同，需要在较小数的末尾补零进行相加。
	 * @author 任宏友
	 *
	 */
//	/**
//	 * 返回求和结果和进位
//	 */
//	public class PartialSum {
//		public LinkedListNode sum = null;
//		public int carry = 0;
//	}
//	/**
//	 * 链表表示的数字为逆序时，采用这个方法进行数字相加。
//	 * @param node1
//	 * @param node2
//	 * @param carry
//	 * @return
//	 */
//	public LinkedListNode addListsReverse(LinkedListNode node1, LinkedListNode node2, int carry) {
//		if(null == node1 && null == node2 && 0 == carry) {
//			return null;
//		}
//		LinkedListNode rst = new LinkedListNode(0, null, null);
//		int value = carry;
//		if(null != node1) {
//			value += (Integer) node1.getData();
//		}
//		if(null != node2) {
//			value += (Integer) node2.getData();
//		}
//		rst.setData(value % 10);
//		LinkedListNode more = addListsReverse(
//				(null == node1) ? null : node1.next, (null == node2) ? null : node2.next, (1 == value / 10) ? 1 : 0);
//		rst.next = more;
//		return rst;
//	}
//	/**
//	 * 链表表示的数字为顺序时，采用这个方法进行数字相加。
//	 * @param node1
//	 * @param node2
//	 * @param carry
//	 * @return
//	 */
//	public LinkedListNode addListsOrdered(LinkedListNode node1, LinkedListNode node2, int carry) {
//		PartialSum sum = new PartialSum();
//		int length1 = length(node1);
//		int length2 = length(node2);
//		//对较短的链表高位进行补零
//		if(length1 < length2) {
//			filledSpaceWithZero(node1, length2 - length1);
//		} else {
//			filledSpaceWithZero(node2, length1 - length2);
//		}
//		//对两个链表进行求和
//		sum = addListHelper(node1, node2);
//		//如果有进位，插入首位，否则直接返回
//		if(0 == sum.carry) {
//			return sum.sum;
//		} else {
//			LinkedListNode finalRes = insertBefore(sum.sum, sum.carry);
//			return finalRes;
//		}
//	}	
//	public LinkedListNode filledSpaceWithZero(LinkedListNode node, int space) {
//		LinkedListNode head = node;
//		for(int i = 0; i < space; i++) {
//			LinkedListNode temp = new LinkedListNode(0, null, null);
//			temp.next = head;
//			head = temp;
//		}
//		return head;
//	}	
//	public PartialSum addListHelper(LinkedListNode node1, LinkedListNode node2) {
//		PartialSum sum = new PartialSum();
//		if(null == node1 && null == node2) {
//			return sum;
//		}
//		//对应为相加
//		sum = addListHelper(node1.next, node2.next);
//		int value = sum.carry + (Integer) node1.getData() + (Integer) node2.getData();
//		//插入当前数字的求和结果
//		LinkedListNode rst = insertBefore(sum.sum, value % 10);
//		sum.sum = rst;
//		sum.carry = value / 10;
//		return sum;
//	}	
//	/**
//	 * 将结点插入链表首部
//	 * @param node
//	 * @param data
//	 * @return
//	 */
//	public LinkedListNode insertBefore(LinkedListNode node, int data) {
//		LinkedListNode temp = new LinkedListNode(data, null, null);
//		if(null != node) {
//			temp.next = node;
//		}
//		return temp;
//	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(9);
		list1.add(9);
		list1.add(9);

		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(1);
		list2.add(0);
		list2.add(0);
		
		LinkedList<Integer>.LinkedListNode<Integer> list3 = (LinkedList<Integer>.LinkedListNode<Integer>) 
				list1.addListsReverse(list1.getHead(), list2.getHead(), 0);
		LinkedList<Integer>.LinkedListNode<Integer> list4 = (LinkedList<Integer>.LinkedListNode<Integer>) 
				list2.addListsOrdered(list1.getHead(), list2.getHead(), 0);
		
		System.out.println(list1.toString());
		System.out.println(list2.toString());
		System.out.println(list1.toString(list3));
		System.out.println(list1.toString(list4));
	}
}
