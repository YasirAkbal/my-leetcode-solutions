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
    private int leftHeight(TreeNode root) {
        if(root == null) return 0;
        
        return 1 + leftHeight(root.left);
    }
    
    private int rightHeight(TreeNode root) {
        if(root == null) return 0;
        
        return 1 + rightHeight(root.right);
    }
    
    int sum = 0;
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        
        if(leftHeight == rightHeight) {
            return (int)Math.pow(2,leftHeight)-1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}