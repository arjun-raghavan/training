/**
 * 
 */
package goldman;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author AR350758
 * FormBiggestNumber.java Aug 20, 2019 11:06:40 AM
 */
public class FormBiggestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(biggestNumber(new int[] {54, 546, 548, 60}));
		System.out.println(biggestNumber(new int[] {1, 34, 3, 98, 9, 76, 45, 4}));

		
	}

	/**
	 * @param is
	 * @return
	 */
	private static String biggestNumber(int[] intArray) {
		
		List<Integer> list = Arrays.stream(intArray)		// IntStream
									.boxed()  		// Stream<Integer>
									.collect(Collectors.toList());

		
		//System.out.println(list);
		
		//Collections.sort(list);
		
//		String largestNumber = Integer.toString(intArray[0]);
//		for(int i = 1; i < intArray.length; i++) {
//			String 
//			
//		}
		
		//System.out.println(list);
		
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				String arg0Str = Integer.toString(arg0);
				String arg1Str = Integer.toString(arg1);
				
				String firstNumber = arg0Str+arg1Str;
				String secondNumber = arg1Str+arg0Str;
				
				//System.out.print("firstNumber = "+firstNumber+", secondNumber = "+secondNumber+" [");
				//System.out.println(firstNumber.compareTo(secondNumber));
				
				return firstNumber.compareTo(secondNumber) > 0 ? -1:1;
			}
		};
		
		Collections.sort(list, comparator);
		//System.out.println(list);
		String value = list.toString();
		value = value.replace("[", "").replaceAll(", ", "").replace("]", "");
		
		//System.out.println(value);
		return value;
	}

}
