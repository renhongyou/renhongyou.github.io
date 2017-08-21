package questions.cc150._11sortandsearch;

/**
 * 给定MxN矩阵，每一行、每一列都按照升序排列，请编写代码找出某元素。
 * @author 任宏友
 *
 */
public class Question06 {
	private static String findElementFromMatrix(int[][] matrix, int element) {
		int row = 0;
		int col = matrix[0].length - 1;
		while(row < matrix.length && col >= 0) {
			if(matrix[row][col] == element) {
				return "[" + row + ", " + col + "] ";
			} else if(matrix[row][col] > element) {
				col--;
			} else {
				row++;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1, 5, 9, 13}, {3, 7, 11, 15}, {4, 8, 12, 16}};
		System.out.println(findElementFromMatrix(matrix, 7));
	}
}
