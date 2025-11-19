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
    private int calculateNodeValue(TreeNode root1, TreeNode root2) {
        int val = 0;
        if(root1 != null)
            val += root1.val;
        if(root2 != null)
            val += root2.val;
        return val;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        
        TreeNode newRoot = new TreeNode(calculateNodeValue(root1,root2));
        newRoot.left = mergeTrees(root1 != null ? root1.left : null, 
                                  root2 != null ? root2.left : null);
        newRoot.right = mergeTrees(root1 != null ? root1.right : null,
                                   root2 != null ? root2.right : null);
        
        return newRoot;
    }
}