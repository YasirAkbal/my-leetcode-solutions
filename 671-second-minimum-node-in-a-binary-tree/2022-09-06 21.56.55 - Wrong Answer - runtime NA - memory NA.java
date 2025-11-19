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
    
    int min, possibleSecondMin;
    public int solution(TreeNode root) {
        if(root == null) return possibleSecondMin;
        if(root.left == null && root.right == null) return possibleSecondMin;
        if(root.left.val == root.right.val) return possibleSecondMin;
        
        if(root.val == root.left.val) {
            if(root.right.val >= possibleSecondMin) return possibleSecondMin;
            else return root.right.val;
        }  else {
            if(root.left.val >= possibleSecondMin) return possibleSecondMin;
            else return root.left.val;
        }
    }
    
    public int findSecondMinimumValue(TreeNode root) {
        int result;
        min = root.val;
        
        if(root.left == null && root.right == null) return -1;
        
        if(min == root.left.val) {
            possibleSecondMin = root.right.val;
            result = solution(root.left);
        } else {
            possibleSecondMin = root.left.val;
            result = solution(root.right);
        } 
        
        return result == min ? -1 : result;
    }
}