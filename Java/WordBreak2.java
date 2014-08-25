/* Word Break II
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
*/

import java.util.*;

public class WordBreak2 {
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dic = new HashSet<String>();
		dic.addAll(Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"}));
		System.out.println(solution(s, dic));
        
        // this case is falling for solution one: "java.lang.OutOfMemoryError"
		String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Set<String> dic2 = new HashSet<String>();
		dic2.addAll(Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}));
		System.out.println(solution2(s2, dic2));
	}
    
	//DP solution
	public static List<String> solution(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        
        boolean[] p = new boolean[s.length()+1];
        p[0] = true;
        
        List<List<String>> words = new ArrayList<List<String>>();
        for (int i = 0; i <= s.length(); i++) {
        	words.add(new ArrayList<String>());  
    	}

    	words.get(0).add("");  

		for (int i = 1; i <= s.length(); i++) {
		    for (int k = 0; k < i; k ++) {
		    	String temp = s.substring(k, i); // this O(n)

		        if (p[k] && dict.contains(temp)) {
		            p[i] = true;

		            for (String str : words.get(k)) {
		            	if (str.equals("")) {
		            		words.get(i).add(String.format("%s", temp));  
		            	} else {
		            		words.get(i).add(String.format("%s %s", str, temp)); 
		            	}
		            }
		        }
		    }
		}

		return words.get(s.length());
	}
    
    // Solution came from http://www.binglu.me/leetcode-word-break-and-word-break-ii/
    /* The idea is: creating an ArrayList for each characters, then working from right to left, 
     * if a character is the start of a word, store the word’s ending character’s index(actually 
     * it’s plus one, for the sake of substring()) to its list. After one pass, we can build all 
     * possible solutions based on the record.
     */ 
	public static List<String> solution2(String s, Set<String> dict) {
        //create the word ending character's index list for each character
        ArrayList<ArrayList<Integer>> record = new ArrayList<ArrayList<Integer>>(s.length());
        for(int i = 0; i < s.length(); i++) {
            record.add(new ArrayList<Integer>());
        }
 
        //each character can be the ending character of some word
        for(int i = s.length(); i >= 0; i--){
 
            if(i < s.length() && record.get(i).isEmpty())
                continue;
            
            //find the starting character for the current ending character
            for(int k = i-1; k >= 0; k--){
                if(dict.contains(s.substring(k, i))) {
                    record.get(k).add(i);    //add current end to start character's list
                }
            }
        }
        
        ArrayList<String> solutionSet = new ArrayList<String>();
        buildSolution(record, 0, s, "", solutionSet);
        
        return solutionSet;
    }

    public static void buildSolution(ArrayList<ArrayList<Integer>> record, int current, String s, 
                String solution, ArrayList<String> solutionSet){
        
        //iterate on current character's word ending list
        for (Integer end : record.get(current)){
            String sub = s.substring(current,end);
            /*
                since the loop may have many iterations, we should keep the reference
                of "solution", rather than writing as "solution += ..."
            */
            String newSolution = solution + (current == 0 ? sub : " " + sub);
            
            if (end == s.length()) {
                solutionSet.add(newSolution);
            } else {
                buildSolution(record,end,s,newSolution,solutionSet);
            }
        }
    }
} 