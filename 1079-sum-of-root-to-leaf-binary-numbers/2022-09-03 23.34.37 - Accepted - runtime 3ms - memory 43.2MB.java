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
    
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0, currNumber = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 0));
        
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            root = pair.getKey();
            currNumber = pair.getValue();
            
            if(root != null) {
                currNumber = currNumber*2 + root.val;
                if(root.left == null && root.right == null) {
                    sum += currNumber;
                } else {
                    stack.push(new Pair(root.left, currNumber));
                    stack.push(new Pair(root.right, currNumber));
                }
            }
        }
        
        return sum;
    }
}