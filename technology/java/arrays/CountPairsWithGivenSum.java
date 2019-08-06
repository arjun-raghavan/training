package arrays;

/**
 * Given an array of integers, and a number ‘sum’, find the number of pairs of
 * integers in the array whose sum is equal to ‘sum’.
 * 
 * @author Arjun
 *
 */
public class CountPairsWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, -1, 5 };

		int sum = 6;
		getPairsCount(arr, sum);//3

		int[] arr1 = { 1, 5, 7, -1 };
		getPairsCount(arr1, 6);// 2

		int[] arr2 = { 1, 1, 1, 1 };
		getPairsCount(arr2, 2);// 6

		int arr3[] = { 10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1 };
		getPairsCount(arr3, 11);// 9
	}

	public static void getPairsCount(int[] arr, int sum) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] + arr[j]) == sum) {
					count++;
				}
			}
		}

		System.out.println("Count = " + count);
	}
}
