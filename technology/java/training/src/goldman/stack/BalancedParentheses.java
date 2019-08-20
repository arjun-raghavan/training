/**
 * 
 */
package goldman.stack;

import java.util.Stack;

/**
 * @author AR350758 BalancedParentheses.java Aug 20, 2019 10:33:56 PM
 */
public class BalancedParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isBalanced("[()]{}{[()()]()}"));
		System.out.println(isBalanced("[(])"));
		
	}

	/**
	 * @param string
	 * @return
	 */
	private static boolean isBalanced(String string) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<Character>();
		char[] arrayStr = string.replaceAll("\\s", "").toCharArray();

		if (arrayStr.length % 2 != 0)
			return false;

		for (int i = 0; i < arrayStr.length; i++) {
			char value = arrayStr[i];
			if ((value == ']') || value == ')' || value == '}') {
				if (stack.isEmpty()) {
					return false;
				} else {
					if (!isMatching(value, stack.pop())) {
						return false;
					}
				}
			} else if ((value == '[') || value == '(' || value == '{') {
				stack.push(value);
			} else {
				return false;
			}
		}

		if (!stack.isEmpty()) {
			return false;
		}

		return true;
	}

	/**
	 * @param value
	 * @param pop
	 * @return
	 */
	private static boolean isMatching(char value, char pop) {

		if (pop == '(' && value == ')') {
			return true;
		} else if (pop == '[' && value == ']') {
			return true;
		} else if (pop == '{' && value == '}') {
			return true;
		} else {
		}
		return false;
	}

}
