class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int left = 0;
        long currentSum = 0;
        long incrementsNeeded;
        int result = Integer.MIN_VALUE;
        for(int right = 0; right < n; right++) {
            currentSum += nums[right];
            incrementsNeeded = (long)nums[right] * (right - left + 1) - currentSum;
            
            while(incrementsNeeded > k && left < right) {
                currentSum -= nums[left];
                left++;
                incrementsNeeded = (long)nums[right] * (right - left + 1) - currentSum;
            }
            
            result = Math.max(result, right - left + 1);
        }


        return result;
    }
}