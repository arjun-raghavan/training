package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {

	public static String logic(int U, int L, int[] C) {
		String IMPOSSIBLE = "IMPOSSIBLE";
		int arrayLength = C.length;
		int[] upperArray = new int[arrayLength];
		int[] lowerArray = new int[arrayLength];

		int sumUpper = 0;
		int sumLower = 0;

		List<Integer> indexes0or1 = new ArrayList<Integer>();
		int totalPendingSum = 0;

		for (int i = 0; i < arrayLength; i++) {
			if (C[i] == 0) {
				upperArray[i] = lowerArray[i] = 0;
			} else if (C[i] == 2) {
				upperArray[i] = lowerArray[i] = 1;
				sumUpper += 1;
				sumLower += 1;
			} else if (C[i] == 1) {
				indexes0or1.add(i);
				totalPendingSum += 1;
			} else {
				return IMPOSSIBLE;
			}
		}

		if ((sumUpper == U) && (sumLower == L)) {
			if ((indexes0or1.size() == 0)) {
				return finalString(upperArray,lowerArray);
			} else {
				return IMPOSSIBLE;
			}
		}

		// totalPendingSum is number of indexes to fill
		// total Pending Sum

		if (((U - sumUpper) + (L - sumLower)) == totalPendingSum) {
			// POSSIBLE
			// Fill Upper till U
			// Fill lower till L
			int index = 0;
			int sizeOfIndex = 0;
			if (indexes0or1.isEmpty()) {
				return IMPOSSIBLE;
			} else {
				sizeOfIndex = indexes0or1.size();
			}

			while (sumUpper != U) {
				int insertIndex = indexes0or1.get(index);
				index++;
				upperArray[insertIndex] = 1;
				sumUpper += 1;
			}

			while (sumLower != L) {
				int insertIndex = indexes0or1.get(index);
				index++;
				lowerArray[insertIndex] = 1;
				sumLower += 1;
			}

			// Return
			
			
			return finalString(upperArray,lowerArray);
		} else {
			return IMPOSSIBLE;
		}
		
	}

	private static String finalString(int[] upperArray, int[] lowerArray) {

		String uStr = Arrays.toString(upperArray).replaceAll(", ", "").replace("[", "").replace("]", "");
		String lStr = Arrays.toString(lowerArray).replaceAll(", ", "").replace("[", "").replace("]", "");
		
		return uStr+","+lStr;
	}

	public static void main(String[] args) {
		int U = 3;
		int L = 2;
		int[] C = new int[] { 2, 1, 1, 0, 1 };

		System.out.println(logic(U, L, C));
		System.out.println(logic(2, 2, new int[] {2,0,2,0}));
		System.out.println(logic(3, 2, new int[] {2,1,1,0,1}));
		System.out.println(logic(2, 3, new int[] {0,0,1,1,2}));
	}

}
