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
    private boolean evaluate(boolean leftBool, boolean rightBool, int root) {    
        if(root == 2) {
            return leftBool || rightBool;
        } else {
            return leftBool && rightBool;
        }
    }
    
    public boolean evaluateTree(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return root.val == 0 ? false : true;
        
        return evaluate(evaluateTree(root.left) , evaluateTree(root.right), root.val);
    }
}