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
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        
        boolean isXFound;
        boolean isYFound;
        int size,i;
        while(!deque.isEmpty()) {
            size = deque.size();
            isXFound = false;
            isYFound = false;
            
            for(i=0;i<size;i++) {
                root = deque.removeFirst();
                
                if(root.val == x)
                    isXFound = true;
                else if(root.val == y)
                    isYFound = true;
                
                if(root.left != null)
                    deque.addLast(root.left);
                
                if(root.right != null)
                    deque.addLast(root.right);
            }
            
            if(isXFound && isYFound)
                return true;
        }
        
        return false;
    }
}