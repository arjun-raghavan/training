package arrays;

public class LeftRotation {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		rotLeft(arr, 4);
		printArray(arr);

		int[] arr1 = new int[] { 41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51 };
		System.out.println("77 97 58 1 86 58 26 10 86 51 41 73 89 7 10 1 59 58 84 77");
		rotLeft(arr1, 10);
		printArray(arr1);

	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println("");
	}

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {
		int temp = 0;
		int arraylength = a.length;
		boolean fromFront = true;
		if (fromFront) {
			// FROM FRONT
			for (int j = 0; j < d; j++) {
				temp = a[0];
				for (int i = 0; i < arraylength - 1; i++) {
					a[i] = a[i + 1];
				}
				a[arraylength - 1] = temp;
			}
		} else {
			// FROM BACK
			for (int j = 0; j < d; j++) {
				for (int i = a.length - 1; i >= 0; i--) {

					if (i == a.length - 1) {
						temp = a[i];
						a[i] = a[0];
					} else {
						a[i] = temp + a[i];
						temp = a[i] - temp;
						a[i] = a[i] - temp;
					}
				}
			}
		}

		return a;

	}

}
