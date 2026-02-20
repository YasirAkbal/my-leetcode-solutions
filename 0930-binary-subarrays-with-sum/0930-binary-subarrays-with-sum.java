class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        
        int result = 0;
        int prefixZeros = 0;
        int prefixSum = 0;

        int left = 0;
        for(int right = 0; right < n; right++) {
            prefixSum += nums[right];

            while(left <= right && prefixSum > goal) { //validate window
                prefixSum -= nums[left];
                prefixZeros = 0;
                left++;
            }

            while(left < right && nums[left] == 0 && prefixSum == goal) { //count prefix zeros
                prefixZeros++;
                left++;
            }

            if(prefixSum == goal) {
                result += 1 + prefixZeros;
            }
        }

        return result;
    }
}