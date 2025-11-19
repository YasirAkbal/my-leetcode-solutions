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
        if(root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        int sum = 0;
        while(!que.isEmpty()) {
            final int size = que.size();
            sum *= 4;
            
            for(int i=0;i<size;i++) {
                root = que.removeFirst();
                sum += root.val;
                
                if(root.left != null)
                    que.addLast(root.left);
            
                if(root.right != null)
                    que.addLast(root.right);
            }
        }
        
        return sum;
    }
}