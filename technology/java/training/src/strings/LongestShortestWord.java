package strings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class LongestShortestWord {
	public static void main(String[] args) {
		String str = "I am an intern at geeksforgeeks";

		Scanner input = new Scanner(System.in);
		String userString = input.nextLine();
		input.close();

		countCharacterInString(userString);
		countWordsInString(userString);
		LongestWordLength(str);
		printNumberOfIntegerDigitsInString(userString);
		printNumberOfSentences(userString);
	}

	private static void printNumberOfSentences(String userString) {
		if (userString == null || userString.isEmpty()) {
			System.out.println("" + 0);
		} else {
			String[] newSentenceArray = userString.split("[!?.:]+");
			for(int i = 0; i < newSentenceArray.length; i++) {
				System.out.println(""+newSentenceArray[i]);
			}
			System.out.println("" + newSentenceArray.length);
		}
	}

	private static void countWordsInString(String userString) {
		if (userString == null || userString.isEmpty()) {
			System.out.println("" + 0);
		} else {
			countWordsUsingRegex(userString);
			countWordsUsingTokenizer(userString);
			countWordsUsingLoop(userString);

		}

	}

	private static void countWordsUsingRegex(String userString) {
		String[] newWordsArray = userString.split("[\\s,]+");
		System.out.println("[Regex] number of words = " + newWordsArray.length);

	}

	private static void countWordsUsingTokenizer(String userString) {
		StringTokenizer tokens = new StringTokenizer(userString);
		System.out.println("[Tokenizer] number of words = " + tokens.countTokens());

	}

	private static void countWordsUsingLoop(String userString) {
		int wordCount = 0;

		boolean isWord = false;
		int endOfLine = userString.length() - 1;
		char[] characters = userString.toCharArray();

		for (int i = 0; i < characters.length; i++) {

			// if the char is a letter, word = true.
			if (Character.isLetter(characters[i]) && i != endOfLine) {
				isWord = true;

				// if char isn't a letter and there have been letters before,
				// counter goes up.
			} else if (!Character.isLetter(characters[i]) && isWord) {
				wordCount++;
				isWord = false;

				// last word of String; if it doesn't end with a non letter, it
				// wouldn't count without this.
			} else if (Character.isLetter(characters[i]) && i == endOfLine) {
				wordCount++;
			}
		}

		System.out.println("[Loop] number of words = " + wordCount);

	}

	private static void printNumberOfIntegerDigitsInString(String userString) {
		String newText = userString.replaceAll("[^0-9]", "");
		System.out.println("number of integer digits" + newText.length());
	}

	private static void countCharacterInString(String userString) {
		String newText = userString.replaceAll("[^e]", "");
		System.out.println("newText = " + newText + ", length=" + newText.length());
		/*
		 * int charCount = 0; for (Character c : userString.toCharArray()) { if (c ==
		 * 'e') { charCount++; } } System.out.println("Count of E = " + charCount);
		 */
	}

	private static void LongestWordLength(String str) {
		String[] stringArray = str.split(" ");

		String largestWord = null;
		String smallestWord = null;

		int largestWordCount = 0;
		int smallestWordCount = 0;
		for (String word : stringArray) {

			if (largestWord == null & smallestWord == null) {
				largestWord = smallestWord = word;
				largestWordCount = smallestWordCount = word.length();
			} else {
				if (largestWordCount < word.length()) {
					largestWord = word;
				}

				if (smallestWordCount > word.length()) {
					smallestWord = word;
				}
			}

		}
		System.out.println("" + smallestWord + " " + largestWord);
	}
}
