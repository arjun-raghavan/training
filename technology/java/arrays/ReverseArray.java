/**
 * 
 */
package arrays;

/**
 * @author AR350758 ReverseArray.java Aug 14, 2019 3:13:00 PM
 */
public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3 };
		// Output : arr[] = {3, 2, 1}
		printArray(arr);
		printArray(reverseArray(arr));
		int[] arr1 = new int[] { 4, 5, 1, 2 };
		// Output : arr[] = {2, 1, 5, 4}
		printArray(arr1);
		printArray(reverseArray(arr1));
	}

	/**
	 * @param arr
	 */
	private static void printArray(int[] arr) {
		for(int i :arr)
			System.out.print(i);
		System.out.println("");
	}

	// Complete the reverseArray function below.
	static int[] reverseArray(int[] a) {
			int startIndex = 0;
			int endIndex = a.length-1;
			while (startIndex < endIndex) {
				int temp = a[startIndex];
				a[startIndex] = a[endIndex];
				a[endIndex] = temp;
				startIndex++;
				endIndex--;
			}
			return a;
	}
}
