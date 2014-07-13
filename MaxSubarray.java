/*Maximum Subarray 
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/


public class MaxSubarray {
    public static void main(String[] args) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
    }

    //Kadane's algorithm O(n) 
    public static int maxSubArray(int[] A) {
        int max_ending_here = A[0];
        int max_so_far = A[0];
        
        for (int i = 1; i <= A.length - 1; i ++) {
            if (max_ending_here < 0) {
                max_ending_here = A[i];
            } else {
                max_ending_here += A[i];
            }
            
            if (max_ending_here >= max_so_far) {
                max_so_far = max_ending_here;
            }
        }
        
        return max_so_far;
    }

    public static int maxSubArray2(int[] A) {
        int max_ending_here = A[0];
        int max_so_far = A[0];
        
        for (int i = 1; i <= A.length - 1; i ++) {
        	max_ending_here = Math.max(A[i], max_ending_here + A[i])
       		max_so_far = Math.max(max_so_far, max_ending_here);
        }
        
        return max_so_far;
    }
 }