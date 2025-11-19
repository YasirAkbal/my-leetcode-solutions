class Solution {
    public double findMaxAverage(int[] nums, int k) {
        final int n = nums.length;
        double max = Integer.MIN_VALUE;
        int kSum = 0;
        
        for(int i=0;i<k;i++) {
            kSum += nums[i];
        }
        
        max = Math.max(max, (double)kSum/k);
        
        for(int i=k;i<n;i++) {
            kSum -= nums[i-k];
            kSum += nums[i];
            
            max = Math.max(max, (double)kSum/k);
        }
        
        return max;
    }
}