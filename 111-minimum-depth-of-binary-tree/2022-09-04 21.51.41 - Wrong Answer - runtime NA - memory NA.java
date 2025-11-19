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
    private int result = Integer.MAX_VALUE;
    
    private int solution(TreeNode root, int depth) {   
        if(root == null) return 0;
        
        if(root.left == null && root.right == null)
            result = Math.min(result,depth);
        
        solution(root.left, depth+1);
        solution(root.right, depth+1);
            
        return result;
    }
    
    public int minDepth(TreeNode root) {
        solution(root,1);
        return result;
    }
}