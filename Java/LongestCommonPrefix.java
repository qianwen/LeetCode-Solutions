/* Longest Common Prefix
 * 
 * A Trie based solution
 * http://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 */

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] s = new String[]{"a", "b"};
		System.out.println(LongestCommonPrefix(s));

		String[] s2 = new String[]{"abab", "aba", "abc"};
		System.out.println(LongestCommonPrefix(s2));

	}

	public static String LongestCommonPrefix(String[] strs) {
	 	if (strs == null || strs.length == 0) {
	 		return "";
	 	}

	 	if (strs.length == 1) {
	 		return strs[0];
	 	}

	 	String lcp = strs[0];
        
        for (int i = 0; i < lcp.length(); i++) {
        	char c = lcp.charAt(i);

        	for (int j = 1; j < strs.length; j++) {
        		if (i == strs[j].length() || c != strs[j].charAt(i)) {
        			lcp = lcp.substring(0, i);
        		}
        	}
        }

	 	return lcp;
	}
}