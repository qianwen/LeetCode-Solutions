/* Unique Binary Search Trees 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * This is not a binary tree problem. Actually, it's more of a math/combinatorics problem.
*/
 
public class NumTree {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
        System.out.println(numTrees2(4));
        System.out.println(numTrees3(4));
    }
    
    // Each value could be the root 
    // recursively find the size of the left and right subtrees 
    // numTree(N) = numTree(1 as root) + numTree(2 as root) + ... + numTree(i as root) + ...+ numTree(N as root)
    // it takes o(n2)
    public static int numTrees(int n) {
    	// when element is 0, an empty tree is possible.
    	// when the element is 1, there is only one tree.
        if (n <= 1) {
        	return 1;
        } else {
        	int sum = 0;
            
        	for (int i = 1; i <= n; i++) {
        		// for each element i as root, find the number of trees possible for i-1 elements in the left
        		// and the number of trees possible for n-i elements in the right. 
        		sum += numTrees(i - 1) * numTrees(n - i);
        	}

        	return sum;
        }
    }
    
    // when i is tht root, the left subtree use [0, i-1] to form and the right subtree use [i+1, n] to form 
    // The total num of trees for i as root: Count[i] = ∑ Count[0...k] * [k+1....i]  0<=k<i-1
    // http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html
    public static int numTrees2(int n) {
    	int[] count = new int[n+1];

    	count[0] = 1;
    	count[1] = 1;

    	for (int i = 2; i <= n; i++) {
    		for (int j = 1; j <= i; j++) {
    			count[i] += count[j-1] * count[i-j]; 
    		}
    	}

    	return count[n];
    }
    
    // Catalan number formula 
    // Cn+1 = (2 * (2n + 1)/ n + 2) * Cn
    public static int numTrees3(int n) {
    	int c = 1; 
        
        for (int i = 2; i <= n; i++) {
            c = 2 * (2*i-1) * c / (i+1);
        }
        
        return c;
    }
}