/**
 * 
 */
package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AR350758 MakingAnagrams.java Aug 22, 2019 8:46:08 PM
 */
public class MakingAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "bcadeh", str2 = "hea"; 
        System.out.println(makeAnagram(str1, str2));
	}

	static int makeAnagram(String a, String b) {
		int count = 0;
		char[] strA = a.toLowerCase().toCharArray();
		char[] strB = b.toLowerCase().toCharArray();
		int[] charCountArray = new int[26];
		
		for(char c : strA) {
			charCountArray[c - 'a'] = charCountArray[c - 'a'] + 1; 
		}
		
		for(char c : strB) {
			charCountArray[c - 'a'] = charCountArray[c - 'a'] - 1; 
		}
		
		for(int charCount : charCountArray) {
			count = count + Math.abs(charCount);
		}

		return count;

	}

	/**
	 * @param countA
	 * @param charArray
	 */
	private static void populateMap(Map<Character, Integer> countA, char[] charArray) {
		for (char c : charArray) {
			if (countA.containsKey(c)) {
				countA.put(c, countA.get(c) + 1);
			} else {
				countA.put(c, 1);
			}
		}

	}

}
