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
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        
        int left = root.left != null ? root.left.val : 0;
        int right = root.right != null ? root.right.val : 0;
        
        return Math.abs(left-right) + findTilt(root.left) + findTilt(root.right);
    }
}