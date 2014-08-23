/* Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 */

 /**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BalancedTree {
	// O(n)
    public boolean isBalanced(TreeNode root) {
     	if (root == null) {
     		return true;
     	}
        
        if (getHeight(root) == -1) {
        	return false;
        }

        return true;
    }

    public int getHeight(TreeNode root) {
    	// empty tree is always balanced
    	if (root == null) {
    		return 0;
    	}
        
        // height of left subtree
    	int leftTree = getHeight(root.left);
    	// left subtree is not balanced
    	if (leftTree == -1) {
    		return -1;
    	}
        
        // height of right subtree
        int rightTree = getHeight(root.right);
    	if (rightTree == -1) {
    		return -1;
    	}
        
        // difference in height
    	int difference = Math.abs(leftTree - rightTree);
    	if (difference > 1) {
    		return -1;
    	} else  {
    		// height of the root node
    		return Math.max(leftTree, rightTree) + 1;
    	}
    }

    // O(n2): The height of the tree is θ(n). And at each level the height is computed which takes O(n) time.
    public boolean isBalanced2(TreeNode root) {
     	if (root == null) {
     		return true;
     	}
        
        // Compute height of the left and right subtree and their difference */
        int heightDifference = computeHeight(root.left) - computeHeight(root.right);

        if (Math.abs(heightDifference) <= 1) {
        	return isBalanced2(root.left) && isBalanced2(root.right);
        } else {
        	return false;
        }
    }

    public int computeHeight(TreeNode root){
      if(root == null) {
      	return 0;
      }

      // Calculate recursively
      return Math.max(computeHeight(root.left), computeHeight(root.right)) + 1;
    } 
}
