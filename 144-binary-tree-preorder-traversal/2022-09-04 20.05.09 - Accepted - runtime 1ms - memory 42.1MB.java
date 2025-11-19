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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;     
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        
        return result;
    }
}