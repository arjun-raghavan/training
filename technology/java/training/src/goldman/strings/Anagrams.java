/**
 * 
 */
package goldman.strings;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author AR350758 Anagrams.java Aug 20, 2019 4:51:15 PM
 */
public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("Keep", "Peek"));
		System.out.println(isAnagram("Mother In Law", "Hitler Woman"));

	}

	static boolean isAnagram(String str1, String str2) {
		String s1 = str1.replaceAll("\\s", "");
		String s2 = str2.replaceAll("\\s", "");

		if (s1.length() != s2.length()) {
			return false;
		}

		char[] arrayS1 = s1.toLowerCase().toCharArray();
		char[] arrayS2 = s2.toLowerCase().toCharArray();

		Arrays.sort(arrayS1);
		Arrays.sort(arrayS2);
		
		return Arrays.equals(arrayS1, arrayS2);

	}

}
