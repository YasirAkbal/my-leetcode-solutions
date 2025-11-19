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
    List<String> result;
    
    private void solution(TreeNode root, String path) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            path += root.val;
            result.add(path);
            return;
        }
        
        solution(root.left, path+root.val+"->");
        solution(root.right, path+root.val+"->");
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        solution(root, "");
        return result;
    }
}