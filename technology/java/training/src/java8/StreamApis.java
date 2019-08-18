/**
 * 
 */
package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author AR350758
 * StreamApis.java Aug 14, 2019 3:53:10 PM
 */
public class StreamApis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] programmingLanguages = {"java", "python", "nodejs", "ruby"};
	    String string1 = "java,python,nodejs,ruby";
	    String string2 = "javapythonnodejsruby";
	    System.out.println(split(string1));
	    System.out.println(splitToListOfChar(string2));
	    
	    System.out.println(join(programmingLanguages));
	    System.out.println(joinWithPrefixPostfix(programmingLanguages));
	    
	}
	
	public static List<String> split(String str){
	    return Stream.of(str.split(","))
	      .map (elem -> new String(elem))
	      .collect(Collectors.toList());
	}
	
	public static String join(String[] arrayOfString){
	    return Arrays.asList(arrayOfString)
	      .stream()
	      //.map(...)
	      .collect(Collectors.joining(","));
	}
	
	public static String joinWithPrefixPostfix(String[] arrayOfString){
	    return Arrays.asList(arrayOfString)
	      .stream()
	      //.map(...)
	      .collect(Collectors.joining(",","[","]"));
	}
	
	public static List<Character> splitToListOfChar(String str) {
	    return str.chars()
	      .mapToObj(item -> (char) item)
	      .collect(Collectors.toList());
	}
	
	/*
	 * public static Map<String, String> arrayToMap(String[] arrayOfString) { return
	 * Arrays.asList(arrayOfString) .stream() .map(str -> str.split(":"))
	 * .collect(toMap(str -> str[0], str -> str[1])); }
	 */
}
