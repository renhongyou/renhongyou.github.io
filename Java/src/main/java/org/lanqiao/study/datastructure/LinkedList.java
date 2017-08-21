package org.lanqiao.study.datastructure;

import java.util.Hashtable;

/**
 * LinkedList
 * @author 任宏友
 *
 */
public class LinkedList<T> extends IList {
	@SuppressWarnings("hiding")
	public class LinkedListNode<T> {
		private T data;
		private LinkedListNode<?> pre;
		private LinkedListNode<?> next;
		
		public LinkedListNode(T data, LinkedListNode<?> pre, LinkedListNode<?> next) {
			super();
			this.data = data;
			this.pre = pre;
			this.next = next;
		}
		
		public Object getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		
		public int compareTo(Object obj){
			if(data.getClass().getName() != obj.getClass().getName()) {
				return 0;
			}
			try {
				switch(data.getClass().getName()) {
				case "java.lang.String" :
					return String.valueOf(data).compareTo(String.valueOf(obj));
				case "java.lang.Integer" :
					if((Integer) data < (Integer) obj) {
						return -1;
					} else {
						return 1;
					}
				}
			} catch (Exception e) {
				System.out.println("结点值类型无法比较！");
			}
			return 0;
		}
	}
	private LinkedListNode<?> head;
	private LinkedListNode<?> tail;
	private int size = 0;
	
	@Override
	public int indexOf(Object obj) {
		int index = 0;
		LinkedListNode<?> temp = head;
		while(null != temp) {
			if((null == temp.data && null == obj) || temp.data.equals(obj)) {
				return index;
			} else {
				temp = temp.next;
				index++;
			}
		}
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if(index >= size) {
			return null;
		}
		return (T) getLinkedListNode(index).data;
	}
	
	public LinkedListNode<?> getHead() {
		return this.head;
	}
	
	public LinkedListNode<?> getTail() {
		return this.tail;
	}

	@Override
	public void add(Object obj) {
		//加头元素
		if(0 == size) {
			head = new LinkedListNode<Object>(obj, null, null);
			tail = head;
		} else {
			LinkedListNode<?> temp = new LinkedListNode<Object>(obj, tail, null);
			tail.next = temp;
			tail = temp;
		}
		size++;
	}

	@Override
	public void add(Object obj, int index) {
		// i最多为size
		if(index > size) {
			throw new IndexOutOfBoundsException();
		}
		if(index == size) {
			add(obj);
		} else {
			LinkedListNode<?> node = getLinkedListNode(index);
			LinkedListNode<?> temp = new LinkedListNode<Object>(obj, null, null);
			if(node == head) {
				head.pre = temp;
				temp.next = head;
				head = temp;
			} else {
				//交换指针
				node.pre.next = temp;
				temp.next = node;
				temp.pre = node.pre;
				node.pre = temp;
			}
			size++;
		}
	}

	@Override
	public Object delete(int index) {
		LinkedListNode<?> node = getLinkedListNode(index);
		Object obj = node.data;
		removeLinkedListNode(node);
		return obj; 
	}
	
	@Override
	void remove(Object obj) {
		LinkedListNode<?> tmp = getLinkedListNode(obj);
		removeLinkedListNode(tmp);
	}
	
	//得到指定的元素
	public LinkedListNode<?> getLinkedListNode(int index) {
		if(index >= size) {
			return null;
		}
		//找到index指向的那个元素
		LinkedListNode<?> node = head;
		int i = 0;
		while(i < index) {
			node = node.next;
			i++;
		}
		return node;
	}
	
	public LinkedListNode<?> getLinkedListNode(Object obj) {
		LinkedListNode<?> temp = head;
		while(null != temp) {
			if((null == temp.data && null == obj) || temp.data.equals(obj)) {
				return temp;
			} else {
				temp = temp.next;
			}
		}
		return null;
	}
	
	public void removeLinkedListNode(LinkedListNode<?> node) {
		//考虑最后一个元素
		if(tail == node) {
			if(null != node.pre) {
				node.pre.next = null;
			}
				size--;
				return;
		}
		if(head == node) {
			if(null != head.next) {
				head.next.pre = null;
			}
			head = head.next;
			size--;
			return;
		}
		if(null != node) {
			node.pre.next = node.next;
			node.next.pre = node.pre;
			size--;
		}
	}
	
	@Override
	public Object search(Object obj) {
		LinkedListNode<?> temp = getLinkedListNode(obj);
		if(null == temp) {
			return null;
		}
		return temp.data;
	}

	@Override
	public int size() {
		return size;
	}
	
	public int length(LinkedListNode<?> node) {
		int count = 0;
		while(null != node) {
			count++;
			node = node.next;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return 0 == size;
	}

	@Override
	public boolean contains(Object obj) {
		return search(obj) != null;
	}
	
	/**
	 * 从头打印整个链表
	 */
	public String toString() {
		LinkedListNode<?> node = head;
		StringBuilder sb = new StringBuilder("[");
		while(null != node) {
			sb.append(node.data.toString()).append(",");
			node = node.next;
		}
		sb.deleteCharAt(sb.lastIndexOf(",")).append("]");
		return sb.toString();
	}
	
	/**
	 * 从指定结点处开始打印链表
	 * @param node
	 * @return
	 */
	public String toString(LinkedListNode<?> node) {
		StringBuffer sb = new StringBuffer("[");
		sb.append(node.data.toString()).append(",");
		while(null != node.next) {
			sb.append(node.next.data.toString()).append(",");
			node = node.next;
		}
		sb.deleteCharAt(sb.lastIndexOf(",")).append("]");
		return sb.toString();
	}
	
	/**
	 * cc150_02LinkedList_Question01<br/>
	 * 移除链表中的重复结点。<br/>
	 * 移除重复结点，需要知道哪些结点是重复的。<br/>
	 * 考虑利用一个哈希表，如果有重复的元素，则将该元素从链表里删除，然后继续迭代。
	 * @param node
	 */
	public void deleteRepeatElement(LinkedListNode<?> node) {
		LinkedListNode<?> previous = null;
		Hashtable<Object, Boolean> table = new Hashtable<Object, Boolean>();
		while(null != node) {
			if(table.containsKey(node.getData())) {
				previous.next = node.next;
			} else {
				table.put(node.getData(), true);
				previous = node;
			}
			node = node.next;
		}
	}
	
	/**
	 * cc150_02LinkedList_Question01<br/>
	 * 移除链表中的重复结点，但不使用到缓冲区。<br/>
	 * 用两个指针，一个current迭代地访问整个链表，一个runner用于检查每个current后续结点是否重复。<br/>
	 * 此举平均时间复杂度为O(n^2)，空间复杂度为O(1)。
	 * @param node
	 */
	public void deleteRepeatElementWithoutUseBuffer(LinkedListNode<?> node) {
		if(null == head) {
			return;
		}
		LinkedListNode<?> current = head;
		while(null != current) {
			LinkedListNode<?> runner = current;
			while(null != runner.next) {
				if(runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	/**
	 * cc150_02LinkedList_Question02<br/>
	 * 找出单向链表中倒数第k个结点。<br/>
	 * 迭代法。使用两个指针point1和point2，将它们指向链表中相距k个结点的两个结点。<br/>
	 * 将point1和point2指向链表头，然后将point2向后移动k个结点。<br/>
	 * 之后，我们以相同的速度移动两个指针。<br/>
	 * point2会在移动length - k步之后抵达链表尾，此时point1指向所求的链表的倒数第k个结点。
	 * @param k
	 * @return
	 */
	public LinkedListNode<?> kFromTail(int k) {
		if(k <= 0) {
			return null;
		}
		LinkedListNode<?> point1 = head;
		LinkedListNode<?> point2 = head;
		
		for(int i = 0; i < k - 1; i++) {
			if(null == point2) {
				return null;
			}
			point2 = point2.next;
		}
		if(null == point2) {
			return null;
		}
		while(null != point2.next) {
			point1 = point1.next;
			point2 = point2.next;
		}
		return point1;
	}
	
	/**
	 * cc150_02LinkedList_Question03<br/>
	 * 删除单向链表中间的某个结点，且只访问该结点。<br/>
	 * 首先将下一个结点赋给本结点，相当于删除了这个结点。<br/>
	 * 此时链表中出现了重复的结点，需要将此时结点的next指向原本下一个结点的next。
	 * @param node
	 * @return
	 */
	public boolean removeLinkedListNodeOnBody(LinkedListNode<Object> node) {
		if(null == node || null == node.next) {
			return false;
		}
		LinkedListNode<?> nodeNext = node.next;
		node.data = nodeNext.data;
		node.next = nodeNext.next;
		return true;
	}
	
	/**
	 * cc150_02LinkedList_Question04<br/>
	 * 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前。<br/>
	 * 可以考虑创建两个链表，一个储存小于x的结点，一个储存大于x的结点，最后连接两个链表。
	 * @param node
	 * @param x
	 * @return
	 */
	public LinkedListNode<?> partitionLinkedList(LinkedListNode<?> node, Object x) {
		LinkedListNode<?> beforeHead = null;
		LinkedListNode<?> beforeTail = null;
		LinkedListNode<?> afterHead = null;
		LinkedListNode<?> afterTail = null;
		while(null != node) {
			LinkedListNode<?> next = node.next;
			node.next = null;
			if(node.compareTo(x) < 0) {
				if(null == beforeHead) {
					beforeHead = node;
					beforeTail = beforeHead;
				} else {
					beforeTail.next = node;
					beforeTail = node;
				}
			} else {
				if(null == afterHead) {
					afterHead = node;
					afterTail = afterHead;
				} else {
					afterTail.next = node;
					afterTail = node;
				}
			}
			node = next;
		}
		if(null == beforeHead) {
			return afterHead;
		}
		beforeTail.next = afterHead;
		return beforeHead;
	}

	/**
	 * cc150_02LinkedList_Question05<br/>
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
	 * 注意要避开空指针异常，如果两个数位数不同，需要在较小数的末尾补零进行相加。
	 * @author 任宏友
	 *
	 */
	/**
	 * 返回求和结果和进位
	 */
	public class PartialSum {
		public LinkedListNode<?> sum = null;
		public int carry = 0;
	}
	/**
	 * 链表表示的数字为逆序时，采用这个方法进行数字相加。
	 * @param node1
	 * @param node2
	 * @param carry
	 * @return
	 */
	public LinkedListNode<?> addListsReverse(LinkedListNode<?> node1, LinkedListNode<?> node2, int carry) {
		if(null == node1 && null == node2 && 0 == carry) {
			return null;
		}
		LinkedListNode<Object> rst = new LinkedListNode<Object>(0, null, null);
		int value = carry;
		if(null != node1) {
			value += (Integer) node1.getData();
		}
		if(null != node2) {
			value += (Integer) node2.getData();
		}
		rst.setData(value % 10);
		LinkedListNode<?> more = addListsReverse(
				(null == node1) ? null : node1.next, (null == node2) ? null : node2.next, (1 == value / 10) ? 1 : 0);
		rst.next = more;
		return rst;
	}
	/**
	 * 链表表示的数字为顺序时，采用这个方法进行数字相加。
	 * @param node1
	 * @param node2
	 * @param carry
	 * @return
	 */
	public LinkedListNode<?> addListsOrdered(LinkedListNode<?> node1, LinkedListNode<?> node2, int carry) {
		PartialSum sum = new PartialSum();
		int length1 = length(node1);
		int length2 = length(node2);
		//对较短的链表高位进行补零
		if(length1 < length2) {
			filledSpaceWithZero(node1, length2 - length1);
		} else {
			filledSpaceWithZero(node2, length1 - length2);
		}
		//对两个链表进行求和
		sum = addListHelper(node1, node2);
		//如果有进位，插入首位，否则直接返回
		if(0 == sum.carry) {
			return sum.sum;
		} else {
			LinkedListNode<?> finalRes = insertBefore(sum.sum, sum.carry);
			return finalRes;
		}
	}	
	public LinkedListNode<?> filledSpaceWithZero(LinkedListNode<?> node, int space) {
		LinkedListNode<?> head = node;
		for(int i = 0; i < space; i++) {
			LinkedListNode<?> temp = new LinkedListNode<Object>(0, null, null);
			temp.next = head;
			head = temp;
		}
		return head;
	}	
	public PartialSum addListHelper(LinkedListNode<?> node1, LinkedListNode<?> node2) {
		PartialSum sum = new PartialSum();
		if(null == node1 && null == node2) {
			return sum;
		}
		//对应为相加
		sum = addListHelper(node1.next, node2.next);
		int value = sum.carry + (Integer) node1.getData() + (Integer) node2.getData();
		//插入当前数字的求和结果
		LinkedListNode<?> rst = insertBefore(sum.sum, value % 10);
		sum.sum = rst;
		sum.carry = value / 10;
		return sum;
	}	
	/**
	 * 将结点插入链表首部
	 * @param node
	 * @param data
	 * @return
	 */
	public LinkedListNode<?> insertBefore(LinkedListNode<?> node, int data) {
		LinkedListNode<?> temp = new LinkedListNode<Object>(data, null, null);
		if(null != node) {
			temp.next = node;
		}
		return temp;
	}
	
	public LinkedListNode<?> findCycleBeginning(LinkedListNode<?> head) {
		LinkedListNode<?> slow = head;
		LinkedListNode<?> fast = head;
		//找到包含相同值的结点
		while(null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if(0 == slow.compareTo(fast)) {
				break;
			}
		}
		//进行检查，如果没有发现包含相同值的结点，则判定没有循环
		if(null == fast || fast.next == null) {
			return null;
		}
		/*
		 * 将slow移到链表头部，将fast留在包含相同值的结点，相距为k。
		 * 如果他们按照k的步调一起往后移动，他们一定分别在环开始和结束的地方停止。
		 */
		slow = head;
		while(0 != slow.compareTo(fast)) {
			slow = slow.next;
			fast = fast.next;
		}
		//现在slow和fast分别指向环的两端
		return fast;
	}
	
	/**
	 * cc150_02LinkedList_Question05<br/>
	 * 检查链表是否为回文。<br/>
	 * 递归求解。
	 * @author 任宏友
	 *
	 */
	public class Result {
		public LinkedListNode<?> node;
	    public boolean result;
	    public Result(LinkedListNode<?> node, boolean result) {
	    	super();
	    	this.node = node;
	    	this.result = result;
	    }
	}
	public Result isPalindromeRecurse(LinkedList<T>.LinkedListNode<?> next, int length) {
	    if (null == next || 0 == length) {
	        return new Result(null, true);
	    }
	    else if(1 == length) {
	        return new Result(next.next, true);
	    }
	    else if(2 == length) {
	        return new Result(next.next.next, next.data == next.next.data);
	    }
	    Result rst = isPalindromeRecurse(next.next, length - 2);
	    if(!rst.result || null == rst.node) {
	        return rst;
	    }
	    else{
	    	rst.result = (next.data == rst.node.data);
	    	rst.node = rst.node.next;
	        return rst;
	    }
	}
	public boolean isPalinddrome(LinkedList<?> list) {
	    @SuppressWarnings("unchecked")
		Result rst = isPalindromeRecurse((LinkedListNode<Object>) list.getHead(), list.size());
	    return rst.result;
	}
}

