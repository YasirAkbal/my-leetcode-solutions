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
    private int sum = 0;
    
    public void solution(TreeNode root) {
        if(root == null) return;
        
        if(root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        
        solution(root.left);
        solution(root.right);
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        solution(root);
        return sum;
    }
}