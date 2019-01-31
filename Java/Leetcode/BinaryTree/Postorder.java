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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<Integer>();
        if (root == null)
            return postorder;
        postorder.addAll(postorderTraversal(root.left));
        postorder.addAll(postorderTraversal(root.right));
        postorder.add(root.val);
        return postorder;
    }
    
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> postorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                postorder.add(0, current.val);
                current = current.right;
            }
            current = stack.pop();
            current = current.left;
        }
        return postorder;
    }
}
