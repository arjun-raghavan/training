package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HourGlassSum {

	public static void main(String[] args) {

		int[][] arr = new int[][] { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 2, 4, 4, 0 }, { 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
		
		System.out.println(""+hourglassSum(arr));

	}

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		//Set sum = new HashSet<Integer>();
		int sum = Integer.MIN_VALUE;
		// Hour glass sum is a 4X4 matrix
		for (int i = 0; i < 4; i++) {
			// First row of hour glass sum
			for (int j = 0; j < 4; j++) {
				// First column of hour glass sum
				int temp_sum = arr[i][j + 0] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j + 0]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if(sum < temp_sum) {
					sum = temp_sum;
				}
			}
		}
				
		return sum;
	}
}
