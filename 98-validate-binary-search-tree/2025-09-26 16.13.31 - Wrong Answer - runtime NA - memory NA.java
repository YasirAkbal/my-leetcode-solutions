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
    public boolean isValidBST(TreeNode root) {
        if(root == null) { return true; }
        return recursive(root.left, 'L', root.val) && recursive(root.right, 'R', root.val);
    }
    
    private boolean recursive(TreeNode node, char nodeType, int minMax) {
        if(node == null) { return true; }
        
        return (nodeType == 'L' && node.val < minMax) &&
            (nodeType == 'R' && node.val > minMax) &&
            recursive(node.left, 'L', Math.min(minMax, node.val)) && 
            recursive(node.right, 'R', Math.max(minMax, node.val));
    }
}