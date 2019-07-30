package strings.regex;

public class RemoveSpecialCharacters {

	public static void main(String[] args) {

		removeAllSpecialCharactersAndPartOfAlphaNumericCharacters();
		removeAllSpecialCharactersAndPartOfAlphaNumericCharactersAndSpace();
		removeFewCharacters();
	}


	private static void removeFewCharacters() {
		// remove all the special characters a part of alpha numeric characters, space and hyphen.
		// Note down the blank space and hyphen just before the ]
		String text = "This - word ! has \\ /allot # of % special % characters";
		text = text.replaceAll("[^a-zA-Z0-9 -]", "");
		System.out.println(text);
		
	}


	private static void removeAllSpecialCharactersAndPartOfAlphaNumericCharacters() {

		// remove all the special characters a part of alpha numeric characters and space
		String text = "This - word ! has \\ /allot # of % special % characters";
		text = text.replaceAll("[^a-zA-Z0-9 ]", "");
		System.out.println(text);
	}
	
	private static void removeAllSpecialCharactersAndPartOfAlphaNumericCharactersAndSpace() {
		// remove all the special characters a part of alpha numeric characters
		//String text = "This - word ! has \\ /allot # of % special % characters";
		String text = "All the best friends. You could do it by yourself!!!";
		//text = text.replaceAll("[^a-zA-Z0-9]", "");
		text = text.replaceAll("\\s", "");
		System.out.println(text);		
	}

}
