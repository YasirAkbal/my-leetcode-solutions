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
    int tilt = 0;
    public void solution(TreeNode root, int pathSum) {
        if(root == null) return;
        
        solution(root.left, pathSum);
        solution(root.right, pathSum);
        
        int left = root.left != null ? root.left.val : 0;
        int right = root.right != null ? root.right.val : 0;
        
        tilt += Math.abs(left-right);
        root.val += (left+right);
    }
    
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        solution(root,0);
        return tilt;
    }
}