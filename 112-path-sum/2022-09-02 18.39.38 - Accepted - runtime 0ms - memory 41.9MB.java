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
    private boolean solution(TreeNode root, int currSum, int targetSum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null) 
            return currSum + root.val == targetSum;
        
        return solution(root.left, currSum+root.val, targetSum) 
            || solution(root.right, currSum+root.val, targetSum);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        return solution(root,0,targetSum);
    }
}