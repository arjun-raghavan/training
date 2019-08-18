package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArrays {

	public static void main(String[] args) {

		// List<Integer> queriesRowItems = new ArrayList<>();
		input1();
	}

	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

		List<ArrayList<Integer>> masterList = new ArrayList<ArrayList<Integer>>();
		List<Integer> lastAnswerList = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			masterList.add(new ArrayList<Integer>());
		}

		int lastAnswer = 0;

		for (int i = 0; i < queries.size(); i++) {
			List<Integer> query = queries.get(i);
			int queryType = query.get(0);
			int x = query.get(1);
			int y = query.get(2);
			int index = (x ^ lastAnswer) % n;
			List<Integer> masterListElement = masterList.get(index);
			if (queryType == 1) {
				// 1
				masterListElement.add(y);
			} else {
				// 2
				int sizeOfMasterListElement = masterList.get(index).size();
				int yIndex = y % sizeOfMasterListElement;
				lastAnswer = masterListElement.get(yIndex);
				// System.out.println(lastAnswer);
				lastAnswerList.add(lastAnswer);
			}	
		}

		return lastAnswerList;
	}

	private static void input1() {
		int n = 2;
		List<List<Integer>> queries = new ArrayList<>();
		{
			Integer[] arr0 = new Integer[] { 1, 0, 5 };
			List<Integer> listArr0 = Arrays.asList(arr0);
			queries.add(listArr0);
		}

		{
			Integer[] arr0 = new Integer[] { 1, 1, 7 };
			List<Integer> listArr0 = Arrays.asList(arr0);
			queries.add(listArr0);
		}

		{
			Integer[] arr0 = new Integer[] { 1, 0, 3 };
			List<Integer> listArr0 = Arrays.asList(arr0);
			queries.add(listArr0);
		}

		{
			Integer[] arr0 = new Integer[] { 2, 1, 0 };
			List<Integer> listArr0 = Arrays.asList(arr0);
			queries.add(listArr0);
		}

		{
			Integer[] arr0 = new Integer[] { 2, 1, 1 };
			List<Integer> listArr0 = Arrays.asList(arr0);
			queries.add(listArr0);
		}

		printList(dynamicArray(n, queries));

	}

	private static void printList(List<Integer> dynamicArray) {
		// TODO Auto-generated method stub

		for (int i = 0; i < dynamicArray.size(); i++) {
			System.out.println(dynamicArray.get(i));
		}

	}
}
