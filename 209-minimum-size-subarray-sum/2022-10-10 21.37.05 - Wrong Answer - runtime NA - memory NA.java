class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        final int n = nums.length;
        
        int minLen = n+1;
        int sum = nums[0];
        int i = 1, j = 0;
        
        while(i < n && j < n) {
            if(sum < target) {
                sum += nums[i++];
            } else {
                minLen = Math.min(minLen, i-j);  
                sum -= nums[j++];
            }
        }
        
        while(sum - nums[j] >= target) {
            sum -= nums[j++]; 
        }
        
        return minLen > n+1 ? 0 : Math.min(minLen, n-j);
    }
}