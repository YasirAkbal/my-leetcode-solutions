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
    private StringBuilder result = new StringBuilder();
    
    private void solution(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        
        result.append("(");
        if(root.left != null)
            result.append(root.left.val);
        solution(root.left);
        result.append(")");
        
        if(root.right != null) {
            result.append("(");
            result.append(root.right.val);
            solution(root.right);
            result.append(")");
        }
    }

    public String tree2str(TreeNode root) {
        if(root == null) return "";
        
        result.append(root.val);
        solution(root);
        
        return result.toString();
    }
}