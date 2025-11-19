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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        recursive(root, result, 0);
        return result;
    }
    
    public void recursive(TreeNode root, List<List<Integer>> listOfLists, int i) {
        if(root == null) { return; }
        if(listOfLists.size() == i) {
            listOfLists.add(new ArrayList<>());
        }
        
        List<Integer> list = listOfLists.get(i);
        list.add(root.val);
        
        recursive(root.left, listOfLists, i+1);
        recursive(root.right, listOfLists, i+1);
    }
}