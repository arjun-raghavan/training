/**
 * 
 */
package arrays;

import java.util.HashMap;

/**
 * Starting with a 1-indexed array of zeros and a list of operations, for each
 * operation add a value to each of the array element between two given indices,
 * inclusive. Once all operations have been performed, return the maximum value
 * in your array.
 * 
 * @author AR350758 ArrayManipulation.java Aug 14, 2019 5:06:29 PM
 */
public class ArrayManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 int n = 10;
//		 int[][] queries = new int[][] { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } };
//		 int[][] queries = new int[][] { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } };
		int n = 5;
		int[][] queries = new int[][] { { 1, 2, 100 }, { 2, 5, 100 }, { 3, 4, 100 } };
		System.out.println("" + arrayManipulation(n, queries));
	}

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
		long largestNumber = Long.MIN_VALUE;
		long[] longArray = new long[n + 2];

		for (int[] query : queries) {
			int startIndex = query[0];
			int endIndex = query[1];
			long insertValue = query[2];
			longArray[startIndex] += insertValue;
			longArray[endIndex + 1] -= insertValue;
			
		}

		printArray(longArray);
		long previousIndexValue = 0;
		for (int i = 1; i <= n; i++) {
			long currentValue = previousIndexValue + longArray[i];
			if (largestNumber < currentValue) {
				largestNumber = currentValue;
			}
			previousIndexValue = currentValue;
		}
		// Arrays.stream(originalArray).max().getAsLong();
		return largestNumber;

	}

	// Complete the arrayManipulation function below.
	static long arrayManipulation1(int n, int[][] queries) {
		int[] originalArray = new int[n];

		long largest = Long.MIN_VALUE;
		for (int[] query : queries) {
			int startIndex = query[0] - 1;
			int endIndex = query[1] - 1;
			int insertValue = query[2];

			int newArrayLength = queries.length;
			int[] newArray = new int[endIndex + 1 + originalArray.length];

			if (startIndex == 0) {
				// Insert at begining
				int i;
				for (i = startIndex; i <= endIndex; i++) {
					newArray[i] = insertValue;
				}
				System.arraycopy(originalArray, 0, newArray, i, originalArray.length);

			} else {
				// Copy first till start index
				System.arraycopy(originalArray, 0, newArray, 0, startIndex);
				int i;
				for (i = startIndex; i <= endIndex; i++) {
					newArray[i] = insertValue;
				}
				System.arraycopy(originalArray, startIndex, newArray, i, originalArray.length - startIndex);
			}

			originalArray = newArray;

		}

		printArray(originalArray);
		return largest;

	}

	private static void printArray(long[] arr) {
		for (long i : arr)
			System.out.print(i + " ");
		System.out.println("");
	}

	private static void printArray(int[] arr) {
		for (int i : arr)
			System.out.print(i);
		System.out.println("");
	}

}
