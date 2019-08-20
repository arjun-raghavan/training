/**
 * 
 */
package goldman.strings;

/**
 * @author AR350758
 * Palindrome.java Aug 20, 2019 4:46:40 PM
 */
public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(""+checkPalindrome("String"));
		System.out.println(""+checkPalindrome("122343221"));

	}

	/**
	 * @param string
	 * @return
	 */
	private static boolean checkPalindrome(String string) {
		// TODO Auto-generated method stub
		int startIndex = 0;
		int endIndex = string.length() - 1;
		
		while (startIndex < endIndex) {
			if(string.charAt(startIndex) != string.charAt(endIndex)) {
				return false;
			}
			
			startIndex++;
			endIndex--;
		}
		return true;
	}

}
