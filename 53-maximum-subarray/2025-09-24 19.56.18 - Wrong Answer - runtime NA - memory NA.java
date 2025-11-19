class Solution {
    
    //O(n^3)
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) { return nums[0]; }
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int sum = 0;
                for(int k=i;k<j;k++) {
                    sum += nums[k];
                }
                max = Math.max(max,sum);
            }
        }
        
        return max;
    }
}