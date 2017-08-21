package questions.cc150._02linkedlist;

import org.lanqiao.study.datastructure.LinkedList;

/**
 * 给定一个有环链表，实现一个算法返回环路的开头结点。<br/>
 * 有环链表的定义：在链表中某个结点的next元素指向在它前面出现过的结点，则表明该链表存在环路。<br/>
 * 示例<br/>
 * 输入：A -> B -> C -> D -> E -> C（C结点出现了两次）。
 * 输出：C
 * @author 任宏友
 *
 */
public class Question06 {
	public static void main(String[] args) {
		LinkedList<String> testList = new LinkedList<String>();
		testList.add("A");
		testList.add("B");
		testList.add("C");
		testList.add("D");
		testList.add("E");
		testList.add("C");
		
		System.out.println(testList.toString());
		System.out.println(testList.findCycleBeginning(testList.getHead()).getData().toString());	
	}
}
