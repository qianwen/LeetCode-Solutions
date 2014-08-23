/*
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * Answers are conclued from http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 */
import java.util.*;

public class LongestPalindrom {
	public static void main(String[] args) {
		System.out.println(bruteForceSolution("bananas"));
		//abcbabcba
		System.out.println(dpSolution("babcbabcbaccba"));

		System.out.println(centerSolution("babcbabcbaccba"));
	}
    
    // Brute force solution, O(N3)
    // The obvious brute force solution is to pick all possible starting and ending positions for a substring, 
    // and verify if it is a palindrome. There are a total of C(N, 2) such substrings 
    // (excluding the trivial solution where a character itself is a palindrome).
    // Since verifying each substring takes O(N) time, the run time complexity is O(N3).
	public static String bruteForceSolution(String s) {
		int longestStart = 0;
		int longestEnd = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (isPalindromic(s, i, j) && j - i > longestEnd - longestEnd) {
					longestEnd = j;
					longestStart = i;
				}
			}
		}

		return s.substring(longestStart, longestEnd + 1);
	}

	public static boolean isPalindromic(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) return false;

			start++;
			end--;
		}

		return true;
	}
    
    // Dynamic Programming 
    /*
     *P[0,0] =1  //each char is a palindrome
	  P[0,1] =S[0] == S[1]    , P[1,1] =1 
      P[0,2] = S[0] == S[2] && P[1,1], P[1,2] = S[1] == S[2] , P[2,2] = 1
      P[0,3] = S[0] == S[3] && P[1,2], P[1,3] = S[1] == S[3] && P[2,2] , P[2,3] =S[2] ==S[3],  P[3,3]=1      
      
     * P[i,j] = 1  if i ==j
              =  S[i] == S[j]   if j = i+1
              =  S[i] == S[j] && P[i+1][j-1]  if j>i+1  
    */
    // This gives us a run time complexity of O(N2) and uses O(N2) space to store the table.
	public static String dpSolution(String s) {
		int n = s.length();
		int longestStart = 0;
		int longestLength = 0;

		boolean[][] p = new boolean[n][n];
       
        //each char is a palindrome
		for (int i = 0; i < n; i ++) {
			p[i][i] = true;
		}
        
		for (int i = 0; i < n - 1; i ++) {
			// p[i][i + 1] is true when s[i] == s[i + 1];
			if (s.charAt(i) == s.charAt(i + 1)) {
				p[i][i+1] = true;
				longestLength = 2;
				longestStart = i;
			}	
		}

		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i ++) {
				int j = i + len - 1;

				if (s.charAt(i) == s.charAt(j) && p[i+1][j-1]) {
					p[i][j] = true;
					longestLength = len;
					longestStart = i;
				}
			}
		}

		return s.substring(longestStart, longestStart+longestLength);
	}

	// Center expansion
	// O(N2) time and O(1) space:
	public static String centerSolution(String s) {
		if (s.length() == 0) return "";

		if (s.length() == 1) return s;
 		
 		String result = "";
		for (double center = 0.0; center <= s.length() - 1; center += 0.5 ) {
			String temp = expandAroundCenter(s, center);
			if (temp.length() > result.length()) {
				result = temp;
			}
		}

		return result;
	}

	private static String expandAroundCenter(String s, double center) {
		int left = (int)center;
		int right = (int)Math.ceil(center);

		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

	    return s.substring(left+1, right);
	}
    

	public static manacherSolution(String s) {

	}
    
    // Transform S into T.
    // For example, S = "abba", T = "^#a#b#b#a#$".
    // ^ and $ signs are sentinels appended to each end to avoid bounds checking
	private static preProcess(String s) {
		int n = s.length();

		if (n == 0) return "^$";

		Sting temp = "^";
		
	}
}