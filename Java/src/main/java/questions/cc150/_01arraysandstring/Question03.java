package questions.cc150._01arraysandstring;

/**
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * @author 任宏友
 *
 */
public class Question03 {
	/**
	 * 给定两个字符串，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean anagram(String str1, String str2) {
		if( 0 == str1.length() && 0 == str2.length()) {
			return true;
		}
		if (str1.length() != str2.length() || 0 == str1.length() || 0 == str2.length()) {
			return false;
		}
		int[] letters = new int[128];
		char[] arr = str1.toCharArray();
		for (char c : arr) {
			//计算str1里面每个字符的个数
			letters[c] ++;
		}
		for (int i = 0; i < str2.length(); i++) {
			int count = str2.charAt(i);
			if (--letters[count] < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[][] test = {{"apple", "pepal"}, {"carrot", "tarroc"}, {"hello", "1lleo"}, {"", ""}, {"", "123"}};
		for (String[] pair : test) {
			String word1 = pair[0];
			String word2 = pair[1];
			System.out.println(word1 + ", " + word2 + " : " + anagram(word1, word2));
		}
	}
}
