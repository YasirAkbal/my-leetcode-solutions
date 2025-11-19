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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        queue.add(root);
        TreeNode node;
        
        int count, right;
        while(!queue.isEmpty()) {
            count = queue.size();
            right = queue.getLast().val;
            
            for(int i=0;i<count;i++) {
                node = queue.removeFirst();
                
                if(node.left != null)
                    queue.addLast(node.left);
                if(node.right != null)
                    queue.addLast(node.right);
            }
            
            result.add(right);
        }
        
        return result;
    }
}