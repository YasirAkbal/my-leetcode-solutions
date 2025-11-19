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
    private int solution(TreeNode node) {
        if(node == null) return 0;
        
        int leftTreeHeight = solution(node.left);
        if(leftTreeHeight == -1) return -1;
        
        int rightTreeHeight = solution(node.right);
        if(rightTreeHeight == -1) return -1;
        
        if(Math.abs(leftTreeHeight-rightTreeHeight) > 1)
            return -1;
        
        return Math.max(leftTreeHeight,rightTreeHeight) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        return solution(root) != -1;
    }
}