package questions.cc150._01arraysandstring;

/**
 * 实现一个算法，确定一个字符串的所有字符是否全部不同。<br/>
 * 假设不允许使用额外的数据结构，又该如何处理？
 * @author 任宏友
 *
 */
public class Question01 {
	/**
	 * 确定一个字符串的所有字符是否全部不同。
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 128 || 0 == str.length()) {
			return false;
		}
		boolean[] charSet = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}
	/**
	 * 不使用额外的数据结构完成本题
	 * @param str
	 * @return
	 */
	public static boolean isUniqueCharsWithoutDatastructure(String str) {
		if (str.length() > 128 || 0 == str.length()) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle", ""};
		for (String word : words) {
			System.out.println(word + " : " + isUniqueChars(word) + " " 
					+ isUniqueCharsWithoutDatastructure(word));
		}
	}
}
