class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int result = nums[0];
        for(int i=1;i<n;i++) {
            result ^= nums[i];
        }
        
        for(int i=0;i<=n;i++) {
            result = result ^ i;
        }
        
        return result;
    }
}