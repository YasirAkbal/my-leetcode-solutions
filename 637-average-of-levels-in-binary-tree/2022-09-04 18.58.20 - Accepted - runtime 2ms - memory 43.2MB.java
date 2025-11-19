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
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return new LinkedList<>();
        
        Deque<TreeNode> deque = new LinkedList<>();
        List<Double> result = new LinkedList<>();
        
        deque.addLast(root);
        int size, i;
        double avg;
        TreeNode node;
        while(!deque.isEmpty()) {
            size = deque.size();
            avg = 0;
            
            for(i=0;i<size;i++) {
                node = deque.removeFirst();
                
                avg += node.val;
                
                if(node.left != null)
                    deque.addLast(node.left);
                
                if(node.right != null)
                    deque.addLast(node.right);
            }
            
            result.add(avg/size);
        }
        
        return result;
    }
}