package strings;

public class SentenceCount {

	public static void main(String[] args) {
		String userString = "my brother is taller than me@1233334. I always a short man,but smart than him";
				//"All the best friends. You could do it by yourself!!!";
		String newString = userString.replaceAll("\\s+", "");
		System.out.println(""+newString);
		String newString1 = newString.replaceAll("[.]", ". ");
		System.out.println(""+newString1);
//		String[] newSentenceArray = userString.split("[.]");
//		for(int i = 0; i < newSentenceArray.length; i++) {
//			
//			newSentenceArray[i] = newSentenceArray[i].replaceAll("\\s", "");
//			System.out.print(""+newSentenceArray[i]);
//		}
//		System.out.println("" + newSentenceArray.length);
	}

}
mybrotheristallerthanme@1233334. Ialwaysashortman,butsmartthanhim
mybrotheristallerthanme@1233334. Ialwaysashortman,butsmartthanhim