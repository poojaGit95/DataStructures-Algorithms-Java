
public class Util {

	/*
	 * This method in each row changes the values of array to index and index to
	 * values of array. i.e. in each row persons's ranking is placed in index value
	 * of persons's id eg: if person 5 ranking is 1 then index 5 of array holds 1
	 * ->a[5]=1
	 * 
	 * @param pref_list[][] - preference 2D array
	 * 
	 * @return int[][] - returns inverted 2D array
	 */
	public static int[][] invert2DArray(int[][] pref_list) {
		int temp;
		int N = pref_list.length;
		int[][] invertedArray = new int[N][N];
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				temp = pref_list[i][j];
				invertedArray[i][temp] = j;
			}
		}
		return invertedArray;
	}

	/*
	 * This method changes the values of array to index and index to values of
	 * array. i.e. in each persons's ranking is placed in index value of persons's
	 * id eg: if person 5 ranking is 1 then index 5 of array holds 1 ->a[5]=1
	 * 
	 * @param match_list[] - preference 1D array
	 * 
	 * @return int[] - returns inverted 1D array
	 */
	public static int[] inver1DArray(int[] match_list) {
		int N = match_list.length;
		int[] invertedArray = new int[N];
		for (int i = 1; i < N; i++) {
			int temp = match_list[i];
			invertedArray[temp] = i;
		}
		return invertedArray;
	}

}
