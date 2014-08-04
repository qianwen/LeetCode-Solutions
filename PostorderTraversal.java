/* Binary Tree Postorder Traversal 
* Given a binary tree, return the postorder traversal of its nodes' values.
*
*
*/

//Definition for binary tree
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
 
public class PostorderTraversal {
	/* Answer came from http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
	* The key to to iterative postorder traversal is the following:
	* The order of "Postorder" is: left child -> right child -> parent node.
	* Find the relation between the previously visited node and the current node
	* Use a stack to track nodes
	* As we go down the tree, check the previously visited node. If it is the parent of the current node, we should add current node to
	* stack. When there is no children for current node, pop it from stack. Then the previous node become to be under the current node 
	* for next loop.
	*/
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
 
        if(root == null) return lst; 
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
 
        TreeNode prev = null;
        while(!stack.empty()){
            TreeNode curr = stack.peek();
 
            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if(prev == null || prev.left == curr || prev.right == curr){
                //prev == null is the situation for the root node
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }
 
            //go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
            }else if(curr.left == prev){
                if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }
 
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack. 
            }else if(curr.right == prev){
                stack.pop();
                lst.add(curr.val);
            }
 
            prev = curr;
        }
 
        return lst;
    }
}