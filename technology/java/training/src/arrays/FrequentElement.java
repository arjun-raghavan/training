/**
 * 
 */
package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author AR350758 FrequentElement.java Aug 21, 2019 9:47:24 AM
 */
public class FrequentElement {

	static int mostFrequent(int arr[], int n) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();

		int maxCount = Integer.MIN_VALUE;
		int maxCountKey = 0;

		int startIndex = 0;
		int endIndex = arr.length - 1;

		while (startIndex < endIndex) {
			addToMap(count, arr[startIndex]);
			addToMap(count, arr[endIndex]);
			startIndex++;
			endIndex--;
		}

		if (arr.length % 2 != 0) {
			addToMap(count, arr[startIndex]);
		}
		
		for(Entry<Integer, Integer> countKeyValue : count.entrySet()) 
        { 
            if (maxCount < countKeyValue.getValue()) 
            { 
            	maxCountKey = countKeyValue.getKey(); 
            	maxCount = countKeyValue.getValue(); 
            } 
        } 

		return maxCountKey;
	}

	/**
	 * @param count
	 * @param key
	 */
	private static void addToMap(Map<Integer, Integer> count, int key) {
		if (count.containsKey(key)) {
			count.put(key, count.get(key) + 1);
		} else {
			count.put(key, 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 5, 2, 1, 3, 2, 1 };
		int n = arr.length;

		System.out.println(mostFrequent(arr, n));
	}

}
