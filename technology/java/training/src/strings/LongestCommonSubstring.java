/**
 * 
 */
package strings;

/**
 * @author AR350758
 * LongestCommonSubstring.java Aug 21, 2019 5:50:57 PM
 */
public class LongestCommonSubstring {

	static String X, Y; 
	
	public static void main(String[] args) {
		int n, m; 
        X = "abcdxyz"; 
        Y = "xyzabcd"; 
  
        n = X.length(); 
        m = Y.length(); 
  
        System.out.println(lcs(n, m, 0));
	}

	static int lcs(int i, int j, int count) { 
		  
        if (i == 0 || j == 0) { 
            return count; 
        } 
  
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
        	count++;
            count = lcs(i - 1, j - 1, count); 
        } 
        count = Math.max(count, Math.max(lcs(i, j - 1, 0), 
                            lcs(i - 1, j, 0))); 
        return count; 
    } 
	
}
