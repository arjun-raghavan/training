/**
 * 
 */
package arrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * There is a collection of input strings and a collection of query strings. For
 * each query string, determine how many times it occurs in the list of input
 * strings.
 * 
 * @author AR350758 SparseArrays.java Aug 14, 2019 3:25:47 PM
 */
public class SparseArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = new String[] { "ab", "ab", "abc" };
		String[] queries = new String[] { "ab", "abc", "bc" };
		printArray(matchingStrings(strings, queries));
	}

	static int[] matchingStrings(String[] strings, String[] queries) {
		int[] countArray = new int[queries.length];
		int index = 0;
		for (String query : queries) {
			countArray[index] = searchStringInArray(strings, query);
			index++;
		}

		return countArray;
	}

	static int[] matchingStringsJava8(String[] strings, String[] queries) {
		return null;
		
	}

	static int searchStringInArray(String[] strings, String string) {
		int count = 0;

		for (String value : strings) {
			if (value.equals(string)) {
				count++;
			}
		}

		return count;
	}

	private static void printArray(int[] arr) {
		for (int i : arr)
			System.out.print(i);
		System.out.println("");
	}
}
