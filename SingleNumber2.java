/* Single Number II
Given an array of integers, every element appears three times except for one. 
Find that single one. Note: Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory? For this problem, we can't use the XOR operation.
The best way to solve this problem is use "bit count". Create a 32 length int array count[32]. 
count[i] means how many '1' in the ith bit of all the integers. 
If count[i] could be divided by 3, then we ignore this bit, else we take out this bit and form the result.
*/


public class SingleNumber2 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 1, 2, 2, 1, 5};
        System.out.println(singleNumber2(array));
    }

    public static int SingleNumber2(int[] A) {
        int res = 0;
        int[] count = new int[32];
        for (int i = 0; i < 32; i++){
            for (int j = 0; j< A.length; j++){
                int newNumber = 0;
                newNumber = A[j] >> i;

                if((newNumber & 1) == 1){
                   count[i] = count[i]+1;
               }
           }
           if ((count[i]%3) != 0) {
            res = res|(1<<i);
           }
       }
       
       return res;
    }
}