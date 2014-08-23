/* Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */

 public class RemoveDuplicates {
 	public static void main(String[] args) {
 		int[] a = new int[]{1, 1, 3, 3, 4, 5};
		System.out.println(removeDuplicates(a))
 	}
    
    //This method returns the number of unique elements, but does not change the original array correctly. 
    //For example, if the input array is {1, 2, 2, 3, 3}, the array will be changed to {1, 2, 3, 3, 3}. The correct result should be {1, 2, 3}. 
    //Because array's size can not be changed once created, there is no way we can return the original array with correct results
    public static int removeDuplicates(int[] A) {
        if (A.length < 2) {
        	return A.length;
        }

        int index = 0;
        for (int i = 1; i < A.length; i++) {
        	if (A[index] != A[i]) {
        		index++;
        		A[index] = A[i];
        	}
        }

        return index + 1;
    }
}