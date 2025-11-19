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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        
        TreeNode node;
        while(!deque.isEmpty()) {
            final int size = deque.size();
            
            for(int i=0;i<size;i++) {
                node = deque.removeFirst();
                max = Math.max(max,node.val);
                
                if(node.left != null)
                    deque.addLast(node.left);
                
                if(node.right != null)
                    deque.addLast(node.right);
            }
            
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        
        return result;
    }
}