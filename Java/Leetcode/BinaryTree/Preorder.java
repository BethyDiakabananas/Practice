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
    // Recursive
    // Time complexity: O(n)
    // space complexity: O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        if (root == null) 
            return preorder;
        
        preorder.add(root.val);
        preorder.addAll(preorderTraversal(root.left));
        preorder.addAll(preorderTraversal(root.right));
        return preorder;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        // Iterative
        // time complexity: O(n)
        // space complexity: O(n+r);
        List<Integer> preorder = new ArrayList<Integer>();
        Stack<TreeNode> rightNodes = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            preorder.add(node.val);
            if (node.right != null) {
                rightNodes.push(node.right);
            }
            node = node.left;
            if (node == null && !rightNodes.empty()) {
                node = rightNodes.pop();
            }
        }
        return preorder;
    }
}
