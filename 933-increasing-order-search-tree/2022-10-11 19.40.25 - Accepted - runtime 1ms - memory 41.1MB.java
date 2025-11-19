/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void addToStack(TreeNode node, Stack<TreeNode> stack) {
        if(node == null) return;
        
        addToStack(node.right, stack);
        stack.push(node);
        addToStack(node.left, stack);
    }
    
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        
        addToStack(root, stack);
        
        if(stack.isEmpty()) return null;
        
        TreeNode tail = stack.pop();
        tail.left = null;
        TreeNode newRoot = tail;
        
        while(!stack.isEmpty()) {
            tail.right = stack.pop();
            tail.right.left = null;
            tail = tail.right;
        }
        
        return newRoot;
    }
}