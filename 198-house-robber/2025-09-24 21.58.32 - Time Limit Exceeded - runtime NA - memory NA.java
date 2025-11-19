class Solution {
    public int rob(int[] nums) {
        return recursive(nums,0,0);
    }
    
    private int recursive(int[] nums, int i, int sum) {
        if(i >= nums.length) { return sum; }
        
        return Math.max(recursive(nums, i+1, sum), recursive(nums, i+2, sum+nums[i]));
    }
}