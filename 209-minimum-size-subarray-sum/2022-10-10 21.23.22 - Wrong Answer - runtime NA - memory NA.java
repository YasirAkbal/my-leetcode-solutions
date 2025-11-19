class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        final int n = nums.length;
        
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        for(int i=0;i<n;i++) {
            while(j < n && sum >= target) {
                sum -= nums[j];
                j++;
            } 
            
            sum += nums[i];
            if(sum >= target)
                minLen = Math.min(minLen,i-j+1);
        }     
        
        while(j < n && sum - nums[j] >= target) {
            sum -= nums[j];
            j++;
        } 
        
        if(sum >= target)
            minLen = Math.min(minLen,n-j);
        
        return minLen > n ? 0 : minLen;
    }
}