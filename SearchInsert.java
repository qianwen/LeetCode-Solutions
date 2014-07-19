/* Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *You may assume no duplicates in the array.
 *Here are few examples.
 *[1,3,5,6], 5 → 2
 *[1,3,5,6], 2 → 1
 *[1,3,5,6], 7 → 4
 *[1,3,5,6], 0 → 0
*/

public class SearchInsert {
	public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 6};
        System.out.print(searchInsert(a, 2));
        System.out.print(searchInsert2(a, 2));
    }
    
    // O(n) 
    public static int searchInsert(int[] A, int target) {
    	for (int i = A.length -1; i >= 0; i--) {
    		if (A[i] < target) {
    			return i + 1;
    		} else if (A[i] == target) {
    			return i;
    		}
    	}

    	return 0;
    }

    // Binary search algorithm O(log n)
    public static int searchInsert2(int[] A, int target) {  
        if (A.length == 0){  
            return 0;  
        }  

        int start = 0;  
        int end = A.length-1;  
        while (start <= end){  
            int mid = start + (end-start)/2;  
            if(A[mid] < target){  
                start = mid+1;   
            } else {  
                end = mid-1;  
            }  
        }  

        return start;  
    }  
}