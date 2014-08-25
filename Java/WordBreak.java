/* Word Break
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
*/

import java.util.*;

public class WordBreak {
	public static void main(String[] args) {
		String s = "bccdbacdbdacddabbaaaadababadad";
		Set<String> dic = new HashSet<String>();
		dic.addAll(Arrays.asList(new String[]{"cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"}));
		System.out.println(wordBreak(s, dic));
	}
    
    // brute force 
    // This solutuion is too slow. It can't pass the OJ. 
	public static boolean wordBreak(String s, Set<String> dict) {
		boolean flag = false;

		for (int i = 1; i < s.length(); i ++) {
			String subStr = s.substring(0, i);

			if (dict.contains(subStr)) {
				if (i == s.length() - 1) {
					return true;
				}
			}

			flag = wordBreak(s.substring(i), dict);
		}

		return flag;
	}
    
	public static boolean wordBreak2(String s, Set<String> dict) {
		if (s == null || dict == null) {
            return false;
        }

        boolean[] checker = new boolean[s.length()];

		for (int i = 1; i <= s.length(); i++) {
			if (checker[i-1] == false && dict.contains(s.substring(0, i))) {
			    checker[i-1] = true;
				if (i == s.length()) {
					return true;
				}
			}

		    if (checker[i-1] == true) {
		        for (int j = i+1; j <= s.length(); j++) {
		           	if (checker[j-1] == false && dict.contains(s.substring(i, j))) {
			             checker[j-1] = true;
			    
				        if (j == s.length() && checker[j-1] == true) {
					        return true;
			    	    } 
		            }
		        }
		    }
		}

		return false;
	}

	//DP solution
	public static boolean wordBreak3(String s, Set<String> dict) {
		if (s == null || dict == null) {
            return false;
        }
        
        if (dict.size() == 0) {
            return s.length() == 0;
        }
        
        boolean[] p = new boolean[s.length()+1];
        p[0] = true;
        
		for (int i = 1; i <= s.length(); i++) {
		    for (int k = 0; k < i; k ++) {
		        if (p[k] && dict.contains(s.substring(k, i))) {
		            p[i] = true;
		        }
		        
		        if (p[i]) {
		            break;
		        }
		    }
		}

		return p[s.length()];
	}
} 