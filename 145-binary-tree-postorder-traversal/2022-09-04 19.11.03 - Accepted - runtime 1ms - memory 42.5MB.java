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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            
            if(root.left != null)
                stack.push(root.left);
            if(root.right != null)
                stack.push(root.right);
        }
        
        Collections.reverse(result);
        return result;
    }
}