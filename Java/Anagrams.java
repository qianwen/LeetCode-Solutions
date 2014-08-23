/* Anagrams
* Given an array of strings, return all groups of strings that are anagrams.
*/
import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
    	String[] str = new String[]{"binary", "good", "great", "gater", "friend", "refind", "finder"};
    	// use hash map
        System.out.println(anagrams(str));
        // use has table 
        System.out.println(anagrams2(str));
        // the submissions on LeetCode were same run time;
    }

    public static List<String> anagrams(String[] strs) { 	
    	List<String> result = new ArrayList<String>();

    	if (strs.length == 0 || strs == null) {
    		return result;
    	}

    	HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

    	for (String s : strs) {
    		char[] chars = s.toCharArray();

    		// sort the leters of the word in alphabetical order 
    		Arrays.sort(chars);
    		String key = new String(chars);

    		// use sorted letters as a key 
    		if (map.containsKey(key)) {
    			map.get(key).add(s);
    		} else {
    			ArrayList<String> newList = new ArrayList<String>();
    			newList.add(s);
    			map.put(key, newList);
    		}
    	}

    	for (ArrayList<String> list : map.values()) {
    		if (list.size() > 1) {
    			result.addAll(list);
    		}
    	}

    	return result;
    }

    public static List<String> anagrams2(String[] strs) { 	
    	List<String> result = new ArrayList<String>();

    	if (strs.length == 0 || strs == null) {
    		return result;
    	}
    	
    	Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();

    	for (String s : strs) {
    		char[] chars = s.toCharArray();

    		// sort the leters of the word in alphabetical order 
    		Arrays.sort(chars);
    		String key = new String(chars);

    		// use sorted letters as a key 
    		if (table.containsKey(key)) {
    			table.get(key).add(s);
    		} else {
    			ArrayList<String> newList = new ArrayList<String>();
    			newList.add(s);
    			table.put(key, newList);
    		}
    	}
        
        Enumeration keys = table.keys();

        while(keys.hasMoreElements()) {
        	ArrayList<String> list = table.get(keys.nextElement());
        	if (list.size() > 1) {
    			result.addAll(list);
    		}
        }

    	return result;
    }
 }