/* Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without * repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

import java.util.Hashtable;
import java.util.Arrays;

 public class LengthOfLongestSubstring {
 	public static void main(String[] args) {
        // 12
       System.out.println(lengthOfLongestSubstring2("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"));
 	}

 	public static int lengthOfLongestSubstring(String s) {
 		if (s == null || s.length() == 0) {
 			return 0;
 		}

        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
        // any valid string will at least have one char as the longest substring
        int result = 1;
         
        for (int i = 0; i < s.length(); i++) {
        	char curr = s.charAt(i);
        	if (table.containsKey(curr)) {
        		if (table.size() > result) {
        			result = table.size();
        		}

        		i = table.get(curr);
        		table.clear();
        	} else {
        		table.put(curr, i);
        	}
        }

        return Math.max(result, table.size());
    }
    
    // answer found at http://www.lifeincode.net/programming/leetcode-longest-substring-without-repeating-characters/
    //In the worst case we only scan the string twice. So the complexity is O(n).
    //A boolean array is used to save the occurrence of characters. We move one pointer forward, and check the boolean array. 
    //If it is false, we turn it to true. If it’s true, we need to keep moving another pointer forward until it meets the same 
    //character as the first pointer pointing to. We can update the max value every time if we move the first pointer.
    public static int lengthOfLongestSubstring2(String s) {
    	if (s == null || s.length() == 0) {
 			return 0;
 		}

        int prev = 0;
        boolean[] letter = new boolean[256];
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!letter[s.charAt(i)]) {
                letter[s.charAt(i)] = true;
            } else {
                while (s.charAt(prev) != s.charAt(i)) {
                    letter[s.charAt(prev)] = false;
                    prev++;
                }
                prev++;
            }

            max = Math.max(max, i - prev + 1);
        }
        return max;

    }
 }