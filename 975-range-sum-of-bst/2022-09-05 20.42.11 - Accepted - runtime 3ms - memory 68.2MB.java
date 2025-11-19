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
    public int rangeSumBST(TreeNode root, final int low, final int high) {
        if(root == null) return 0;
        
        return ((root.val >= low && root.val <= high) ? root.val : 0)
            + rangeSumBST(root.left,low,high)
            + rangeSumBST(root.right,low,high);
    }
    
    /*int sum = 0;
    public void solution(TreeNode root, final int low, final int high) {
        if(root == null) return;
        
        if(root.val >= low && root.val <= high)
            sum += root.val;
        
        solution(root.left,low,high);
        solution(root.right,low,high);
    }
    
    public int rangeSumBST(TreeNode root, final int low, final int high) {
        solution(root,low,high);
        return sum;
    }*/
}