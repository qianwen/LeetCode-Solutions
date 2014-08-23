/* Single Number 
 * Given an array of integers, every element appears twice except for one. Find that single one.

 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class SingleNumber {
	public static void main(String[] args) {
        int[] a = new int[]{1, 1, 3, 3, 6};
        System.out.print(singleNumber(a));
    }

    public static int singleNumber(int[] A) {
    	int result = A[0];
    	for (int i = 1; i < A.length; i ++) {
    		result ^= A[i];
    	}

    	return result;
    }
}   