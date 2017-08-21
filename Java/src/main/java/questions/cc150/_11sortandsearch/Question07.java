package questions.cc150._11sortandsearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。<br/>
 * 出于实际和没关的考虑，在上面的人要比下面的人矮一点、轻一点。<br/>
 * 已知马戏团每个人的高度和重量，请编写代码计算叠罗汉最多能叠几个人。<br/>
 * 示例<br/>
 * 输入(ht, wt)：(65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)<br/>
 * 输出：从上往下数，叠罗汉最多能叠6层：(56, 90) (60, 95) (65, 100) (68, 110) (70, 150) (75, 190)
 * @author 任宏友
 *
 */
public class Question07 {
	//返回较长的序列
	private static ArrayList<HeightWeight> sequenceWithMaxLength(
			ArrayList<HeightWeight> seq1, ArrayList<HeightWeight> seq2) {
		if(null == seq1) {
			return seq2;
		} else if(null == seq2) {
			return seq1;
		}
		return (seq1.size() > seq2.size()) ? seq1 : seq2;
	}
	//最长的递增子序列
	private static void longestIncreasingSubsequence(
			ArrayList<HeightWeight> arr, ArrayList<HeightWeight>[] solutions, int currentIndex) {
		if(currentIndex >= arr.size() || currentIndex < 0) {
			return;
		}
		HeightWeight currentElement = arr.get(currentIndex);
		//找到最长的可供正确元素放入的序列
		ArrayList<HeightWeight> bestSequence = null;
		for(int i = 0; i < currentIndex; i++) {
			if(arr.get(i).isBefore(currentElement)) {
				//如果这个元素大于列表末尾项，将这个元素置为列表的最大值
				bestSequence = sequenceWithMaxLength(bestSequence, solutions[i]);
			}
		}
		//添加正确元素
		ArrayList<HeightWeight> newSolution = new ArrayList<HeightWeight>();
		if(null != bestSequence) {
			newSolution.addAll(bestSequence);
		}
		newSolution.add(currentElement);
		//加入序列并递归
		solutions[currentIndex] = newSolution;
		longestIncreasingSubsequence(arr, solutions, currentIndex + 1);
	}
	private static ArrayList<HeightWeight> longestIncreasingSubsequence(ArrayList<HeightWeight> arr) {
		@SuppressWarnings("unchecked")
		ArrayList<HeightWeight>[] solutions = new ArrayList[arr.size()];
		longestIncreasingSubsequence(arr, solutions, 0);
		ArrayList<HeightWeight> bestSequence = null;
		for(int i = 0; i < arr.size(); i++) {
			bestSequence = sequenceWithMaxLength(bestSequence, solutions[i]);
		}
		return bestSequence;
	}
	private static ArrayList<HeightWeight> getIncreasingSequence(ArrayList<HeightWeight> arr) {
		Collections.sort(arr);
		return longestIncreasingSubsequence(arr);
	}
	public static ArrayList<HeightWeight> initElement() {
		ArrayList<HeightWeight> arr = new ArrayList<HeightWeight>();
		//(65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
		HeightWeight temp = new HeightWeight(65, 100);
		arr.add(temp);
		temp = new HeightWeight(70, 150);
		arr.add(temp);
		temp = new HeightWeight(56, 90);
		arr.add(temp);
		temp = new HeightWeight(75, 190);
		arr.add(temp);
		temp = new HeightWeight(60, 95);
		arr.add(temp);
		temp = new HeightWeight(68, 110);
		arr.add(temp);
		return arr;
	}
	public static void printList(ArrayList<HeightWeight> arr) {
		for(HeightWeight htwt : arr) {
			System.out.println(htwt.toString() + " ");
		}
	}
	public static void main(String[] args) {
		ArrayList<HeightWeight> arr = initElement();
		ArrayList<HeightWeight> rst = getIncreasingSequence(arr);
		printList(rst);
	}
}

class HeightWeight implements Comparable<HeightWeight> {
	private int height;
	private int weight;
	public HeightWeight(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	@Override
	public int compareTo(HeightWeight htWt) {
		HeightWeight heightWeight = htWt;
		if(this.height != heightWeight.height) {
			return ((Integer) this.height).compareTo(heightWeight.height);
		} else {
			return ((Integer) this.weight).compareTo(heightWeight.weight);				
		}
	}
	public String toString() {
		return "(" + this.height + ", " + this.weight + ") ";
	}
	/*
	 * 如果当前元素处在其他之上应返回true。
	 * 值得注意的是，与compareTo()只会出现要么a > b要么b > a不同，isBefore方法会出现doublefalse的情况。
	 */
	public boolean isBefore(HeightWeight other) {
		if(this.height < other.height && this.weight < other.weight) {
			return true;
		} else {
			return false;
		}
	}
}
