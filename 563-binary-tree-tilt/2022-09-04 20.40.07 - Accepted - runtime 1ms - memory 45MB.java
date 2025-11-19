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
    int x = 0;
    public void solution(TreeNode root, int sum) {
        if(root == null) return;
        
        solution(root.left, sum);
        solution(root.right, sum);
        
        int left = root.left != null ? root.left.val : 0;
        int right = root.right != null ? root.right.val : 0;
        
        x += Math.abs(left-right);
        root.val += (left+right);
    }
    
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        solution(root,0);
        return x;
    }
}