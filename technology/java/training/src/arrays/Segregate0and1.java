package arrays;

/**
 * You are given an array of 0s and 1s in random order. Segregate 0s on left
 * side and 1s on right side of the array. Traverse array only once. Input array
 * = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] Output array = [0, 0, 0, 0, 0, 1, 1, 1, 1,
 * 1]
 * 
 * @author Arjun
 *
 */
public class Segregate0and1 {

	public static void main(String[] args) {

		int arr[] = new int[] { 0, 1, 0, 1, 1, 1 };
		int i, arr_size = arr.length;

		segregate0and1(arr, arr_size);

		System.out.print("Array after segregation is ");
		for (i = 0; i < 6; i++)
			System.out.print(arr[i] + " ");

	}

	private static void segregate0and1(int[] arr, int arr_size) {
		int leftIndex = 0;
		int rightIndex = arr_size-1;
		
		while (leftIndex < rightIndex) {
			
			while(arr[leftIndex] == 0 && (leftIndex < rightIndex)) {
				leftIndex++;
			}
			
			//leftIndex = 1, value = 1
			
			while(arr[rightIndex] == 1 && (leftIndex < rightIndex)) {
				rightIndex--;
			}
			
			if(leftIndex < rightIndex) {
				arr[leftIndex] = 0;
				arr[rightIndex] = 1;
				leftIndex++;
				rightIndex--;
			}
			
			
		}
		
	}

}
