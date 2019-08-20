/**
 * 
 */
package goldman;

import java.util.HashMap;

/**
 * @author AR350758 FirstNonRepeatingCharacter.java Aug 20, 2019 10:44:01 AM
 */
public class FirstNonRepeatingCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(firstNonRepeatingCharacter("GeekforGeeks"));

	}

	/**
	 * @param string
	 * @return
	 */
	private static char firstNonRepeatingCharacter(String string) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();

		for (int i = 0; i < string.length(); i++) {
			char x = string.charAt(i);
			if (!charCount.isEmpty()) {
				if (charCount.containsKey(x))
					charCount.put(x, charCount.get(x) + 1);
				else
					charCount.put(x, 1);
			}else {
				charCount.put(x, 1);
			}
		}
		
		char firstChar;
		
		for (int i = 0; i < string.length(); i++) {
			char x = string.charAt(i);
			if(charCount.get(x) == 1)
				return x;
		}
		
		return ' ';
	}

}
