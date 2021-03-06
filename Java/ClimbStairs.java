/* Climbing Stairs 
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * This is the same problem as Fibonacci number.
 * The solution can be reduced to O(log(n)) by using matrix like solving fibonacci number 
 * Here is a referrence http://ronzii.wordpress.com/2011/07/09/using-matrix-exponentiation-to-calculated-nth-fibonacci-number/
*/


public class ClimbStairs {
	public static void main(String[] args) {
		System.out.println(climbStairs(6));
		System.out.println(climbStairs2(6));
	}

    // Recursive (it could cause stack overflower. not recommended)
	public static int climbStairs(int n) {
		if (n <= 2) {
			return n;
		} else {
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	}
    
    // Iterative O(n)
	public static int climbStairs2(int n) {
		if (n <= 2) {
			return n;
		} 

		int f1 = 1;
		int f2 = 2;

		for (int i = 3; i <= n; i++) {
			int f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		
		return f2;
	}
}
