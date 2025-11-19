class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSums = new int[n];
        prefixSums[0] = nums[0];
        for(int i=1;i<n;i++) {
            prefixSums[i] = prefixSums[i-1] + nums[i];
        }

        int result = 0;

        for(int i=n-1;i>=0;i--) {
            if(prefixSums[i] == k) 
                result++;     
            for(int j=0;j<i;j++) {
                if(prefixSums[i] - prefixSums[j] == k) 
                    result++;
            }
        }

        return result;
    }
}