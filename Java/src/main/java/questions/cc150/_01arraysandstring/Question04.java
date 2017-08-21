package questions.cc150._01arraysandstring;

/**
 * 编写一个方法，将字符串中的空格全部替换为“%20”。<br/>
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。<br/>
 * 示例<br/>
 * 输入："Mr John Smith   "<br/>
 * 输出："Mr%20John%20Smith"
 * @author 任宏友
 *
 */
public class Question04 {
	public static int replaceSpaces(char[] str, int length, char[] replaceChars) {
		int spaceCount = 0;
		int index = 0;
		int i = 0;
		for (i = 0; i < length; i++) {
			if(' ' == str[i]) {
				spaceCount++;
			}
		}
		index = length + spaceCount * 2;
//		str[index] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if(' ' == str[i]) {
				for(int j = 1; j <= replaceChars.length; j++) {
					str[index - j] = replaceChars[replaceChars.length - j];
				}
				index = index - replaceChars.length;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
		return spaceCount;
	}
	
	public static void main(String[] args) {
		String str = "Mr John Smith   ";
		char[] replaceChars = {'%', '2', '0'};
		char[] arr = new char[50];
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		//str.length() - 3是字符串“真实”长度
		int spaceCount = replaceSpaces(arr, str.length() - 3, replaceChars);
		for(int i = 0; i < (str.length() - 3) + spaceCount * 2; i++) {
			System.out.print(arr[i]);
		}
	}
}
