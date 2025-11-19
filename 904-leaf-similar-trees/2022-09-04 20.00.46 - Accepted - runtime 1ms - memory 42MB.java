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
    private List<Integer> getLeafs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(root.left == null && root.right == null)
                    result.add(root.val);
                root = root.right;
            }
        }
        
        return result;
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = getLeafs(root1);
        List<Integer> leafs2 = getLeafs(root2);
        
        if(leafs1.size() != leafs2.size()) return false;
        
        return leafs1.equals(leafs2);
    }
}