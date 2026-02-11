class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int n = nums.length;
      int left = 0, right = 0;
      int sum = 0;
      int result = Integer.MAX_VALUE;
      
      while(right < n) {
         sum += nums[right];
         
         while(left <= right && sum - nums[left] >= target) {
            sum -= nums[left];
            left++;
         }
         
         if(sum >= target) {
            result = Math.min(result, right - left + 1);
         }
         
         right++;
      }
         
      return result == Integer.MAX_VALUE ? 0 : result;
    }
}