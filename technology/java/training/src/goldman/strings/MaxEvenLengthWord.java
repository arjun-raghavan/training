/**
 * 
 */
package goldman.strings;

/**
 * @author AR350758 MaxEvenLengthWord.java Aug 20, 2019 12:32:27 PM
 */
public class MaxEvenLengthWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("" + findMaxLenEven("this is a test string"));
		System.out.println("" + findMaxLenEven("geeksforgeeks is a platform for geeks"));
	}

	/**
	 * @param string
	 * @return
	 */
	private static String findMaxLenEven(String string) {
		String[] arrayStr = string.split(" ");
		int[] arrayStrSize = new int[arrayStr.length];
		
		int maxEvenLength = 0;
		int maxEvenLengthIndex = -1;
		
		for(int i = 0; i < arrayStr.length; i++) {
			int wordLength = arrayStr[i].length();
			if((wordLength % 2) == 0) {
				//even
				if(maxEvenLength < wordLength) {
					maxEvenLength = wordLength;
					maxEvenLengthIndex = i;
				}
			}
		}
		
		return arrayStr[maxEvenLengthIndex];
	}

}
