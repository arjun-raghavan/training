package arrays;

/**
 * You are given an unordered array consisting of consecutive integers [1, 2, 3,
 * ..., n] without any duplicates. You are allowed to swap any two elements. You
 * need to find the minimum number of swaps required to sort the array in
 * ascending order.
 * 
 * For example, given the array we perform the following steps:
 * 
 * 
 * @author Arjun
 *
 */

//For example, given the array  we perform the following steps:
//
//i   arr                         swap (indices)
//0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
//1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
//2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
//3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
//4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
//5   [1, 2, 3, 4, 5, 6, 7]
//	

public class MinimumSwaps2 {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 2, 4, 6, 7 };
//		 System.out.println(minimumSwaps(arr));
		int[] arr1 = new int[] { 7, 1, 3, 2, 4, 5, 6 };
		System.out.println(minSwaps(arr1));
		int[] arr2 = new int[] { 4, 3, 1, 2 };
		// minimumSwaps(arr2);
	}

	static int minSwaps(int[] arr) {
		int swapCount = 0;
		boolean[] visitedArray = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (visitedArray[i] == true) {
				continue;
			}

			int traverseIndex = i;
			int cycleCount = 0;
			while (!visitedArray[traverseIndex]) {
				System.out.print(traverseIndex+" ");
				visitedArray[traverseIndex] = true;
				traverseIndex = arr[traverseIndex] - 1;
				cycleCount++;
			}
			
			System.out.println(" ");
			if(cycleCount > 1)
			swapCount += cycleCount -1;
		}

		return swapCount;
	}

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int swapCount = 0;
		int swappedIndex = 0;
		while (swappedIndex < arr.length) {
			int firstValue = arr[swappedIndex];

			if (firstValue == (swappedIndex + 1)) {
				swappedIndex++;
				continue;
			}

			int insertIndex;
			int insertValue;

			for (int index = swappedIndex + 1; index < arr.length; index++) {

				if (index == firstValue) {
					// push it there
					arr[swappedIndex] = arr[index];
					arr[index] = firstValue;
					swapCount++;
					break;
				} else {
					if (swappedIndex == (arr[index] - 1)) {
						arr[swappedIndex] = arr[index];
						arr[index] = firstValue;
						swapCount++;
						break;
					} else if (firstValue > arr[index]) {
						if (arr[index] < index) {
							arr[swappedIndex] = arr[index];
							arr[index] = firstValue;
							swapCount++;
							break;
						}

					}
				}

			}

			printArray(arr);
		}

		return swapCount;
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println("");
	}
}
