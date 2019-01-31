/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> inorder = new ArrayList<Integer>();
         if (root == null)
             return inorder;
         inorder.addAll(inorderTraversal(root.left));
         inorder.add(root.val);
         inorder.addAll(inorderTraversal(root.right));
         return inorder;
     }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            // add all left nodes into the stack w/ root
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // pop a node from the stack if it's null
            current = stack.pop();
            inorder.add(current.val);
            current = current.right;
        }
        return inorder;
    }
}
