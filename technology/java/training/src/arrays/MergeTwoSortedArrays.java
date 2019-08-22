/**
 * 
 */
package arrays;

/**
 * @author AR350758 MergeTwoSortedArrays.java Aug 21, 2019 4:04:16 PM
 */
public class MergeTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int n1 = arr1.length;

		int[] arr2 = { 2, 4, 6, 8 };
		int n2 = arr2.length;

		int[] arr3 = new int[n1 + n2];

		mergeArrays(arr1, arr2, arr3);

		System.out.println("Array after merging");
		for (int i = 0; i < n1 + n2; i++)
			System.out.print(arr3[i] + " ");
	}

	/**
	 * @param arr1
	 * @param arr2
	 * @param arr3
	 */
	private static void mergeArrays(int[] arr1, int[] arr2, int[] arr3) {

		int len1 = arr1.length;
		int len2 = arr2.length;
		int len3 = arr3.length;

		int index1 = 0;
		int index2 = 0;
		int index3 = 0;

		while ((index1 < len1) && (index2 < len2)) {

			if (arr1[index1] < arr2[index2]) {
				arr3[index3] = arr1[index1];
				index1++;
			} else {
				arr3[index3] = arr2[index2];
				index2++;
			}
			index3++;
		}

		while (index1 < len1) {
			arr3[index3] = arr1[index1];
			index1++;
			index3++;
		}

		while (index2 < len2) {
			arr3[index3] = arr2[index2];
			index2++;
			index3++;
		}

	}

}
