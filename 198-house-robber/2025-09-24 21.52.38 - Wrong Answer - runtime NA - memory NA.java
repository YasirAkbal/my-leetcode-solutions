class Solution {
    public int rob(int[] nums) {
        return Math.max(recursive(nums,0), recursive(nums,1));
    }
    
    private int recursive(int[] nums, int i) {
        if(i >= nums.length) { return 0; }
        
        return nums[i] + recursive(nums, i+2);
    }
}