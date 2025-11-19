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
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursive(null, nums, 0, nums.length-1);
    }
    
    private TreeNode recursive(TreeNode root, int[] nums, int left, int right) {   
        if(right < left) { return null; }
        if(right == left) { return new TreeNode(nums[left]); }
        
        int mid = (left + right) / 2;
        root = new TreeNode(nums[mid]);
        System.out.println(root.val);
        root.left = recursive(root, nums, left, mid-1);
        root.right = recursive(root, nums, mid+1, right); 
        
        
        return root;
    }
}