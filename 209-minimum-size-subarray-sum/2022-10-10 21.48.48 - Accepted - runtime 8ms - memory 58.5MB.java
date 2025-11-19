class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        final int n = nums.length;
        
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        
        for(int i=0;i<n;i++) {
            sum += nums[i];
            
            while(sum >= target) {
                minLen = Math.min(minLen, i-j+1);
                sum -= nums[j++];
            }
        }
        
        return minLen > n ? 0 : minLen;
    }
}