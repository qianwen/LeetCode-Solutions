/* Binary Tree Inorder Traversal 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * The order of "inorder" is: left child -> parent -> right child
 */

//Definition for binary tree
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class InorderTraversal {
	// iteratively O(n) space
    // Answers came from http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		ArrayList<Integer> lst = new ArrayList<Integer>();

		if(root == null)
			return lst; 

		Stack<TreeNode> stack = new Stack<TreeNode>();
        //define a pointer to track nodes
		TreeNode p = root;

		while(!stack.empty() || p != null){

            // if it is not null, push to stack
            //and go down the tree to left
			if(p != null){
				stack.push(p);
				p = p.left;

            // if no left child
            // pop stack, process the node
            // then let p point to the right
			}else{
				TreeNode t = stack.pop();
				lst.add(t.val);
				p = t.right;
			}
		}

		return lst;
	}

    // Morris algorithm Time: O(nlogn) but space O(1)
	public ArrayList<Integer> inorderTraversal2(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		TreeNode cur = root, prev = null;
		while (cur != null){
			if (cur.left != null){
				prev = cur.left;

				while (prev.right != null && prev.right != cur){
					prev = prev.right;
				}    

				if (prev.right == null){
					prev.right = cur;
					cur = cur.left;
				} else {
					res.add(cur.val);
					prev.right = null;
					cur = cur.right;
				}
			} else {
				res.add(cur.val);
				cur = cur.right;
			}
		}

		return res;
	}

	// Recursive
	public ArrayList<Integer> inorderTraversal3(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		recursion(root, res);  
       	return ret;  
    }  
      
    public void recursion(TreeNode root, ArrayList<Integer> res){  
        if(root == null){  
            return;  
        }  
          
        recursion(root.left, res);  
        res.add(root.val);  
        recursion(root.right, res);  
    }  
}