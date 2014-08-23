/* Two Sum
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

import java.util.*;

 public class TwoSum {
 	 public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        System.out.println(twoSum(a, 9));
    }
    
    // Time complexity depends on the put and get operations of HashMap which is normally O(1).
    // Time complexity of this solution: O(n).
    public static int[] twoSum(int[] numbers, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int [] result = new int[2];

    	for (int i = 0; i < numbers.length; i++) {
    		int difference = target - numbers[i];
    		if (map.containsKey(difference)) {
    			int index1 = map.get(difference);
    			result[0] = index1 + 1;
    			result[1] = i + 1;

    		    break;
    		} else {
    			map.put(numbers[i], i);
    		}
    	}

    	return result;
    }
 }