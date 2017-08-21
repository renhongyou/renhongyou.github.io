package questions.cc150._11sortandsearch;

/**
 * 有个排序后的字符串数组，其中散布着一些空字符串，编写一个方法，找出给定字符串的位置。<br/>
 * 示例<br/>
 * 输入：在字符串数组{"at", "",  "", "", "ball", "", "", "car", "", "", "dad", "", ""}中，查找"ball"。<br/>
 * 输出：4。
 * @author 任宏友
 *
 */
public class Question05 {
	private static int searchStringMethod(String[] strings, String str, int first, int last) {
		while(first <= last) {
			int mid = (last + first) / 2;
			//如果mid的元素使空串，则寻找最接近的非空串
			if(strings[mid].isEmpty()) {
				int left = mid - 1;
				int right = mid + 1;
				while(true) {
					if(left < first && right > last) {
						return -1;
					} else if(right <= last && !strings[right].isEmpty()) {
						mid = right;
						break;
					} else if(left >= first && !strings[left].isEmpty()) {
						mid = left;
						break;
					}
					right++;
					left--;
				}
			}
			//检查字符串
			if(str.equals(strings[mid])) {
				//求得所求非空字符串
				return mid;
			} else if(strings[mid].compareTo(str) < 0) {
				//找右边
				return searchStringMethod(strings, str, mid + 1, last);
			} else {
				//找左边
				return searchStringMethod(strings, str, first, mid - 1);
			}
		}
		return -1;
	}
	private static int searchString(String[] strings, String str) {
		if(null == strings || null == str || str.isEmpty()) {
			return -1;
		}
		return searchStringMethod(strings, str, 0, strings.length - 1);
	}
	public static void main(String[] args) {
		String[] strings = {"at", "",  "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(searchString(strings, "dad"));
	}
}
