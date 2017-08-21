package questions.cc150._11sortandsearch;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * 编写一个方法，对字符串数组进行排序，将所有变位词排在相邻的位置。<br/>
 * 变位词：一种把某个词或句子的字母的位置（顺序）加以改换所形成的新词。
 * @author 任宏友
 *
 */
public class Question02 {
	private static String sortChars(String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	private static void sortByAnagrams(String[] arr) {
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		//以变位词来分组
		for(String str : arr) {
			String key = sortChars(str);
			if(!hash.containsKey(key)) {
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(str);
		}
		//将hash转为arr
		int index = 0;
		for(String key : hash.keySet()) {
			LinkedList<String> list = hash.get(key);
			for(String str : list) {
				arr[index] = str;
				index++;
			}
		}
	}
	public static void main(String[] args) {
		String[] testArr = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		sortByAnagrams(testArr);
		System.out.println(Arrays.toString(testArr));
	}
}
