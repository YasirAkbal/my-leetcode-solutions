class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSums = new int[n+1];
        prefixSums[0] = 0;
        for(int i=0;i<n;i++) {
            prefixSums[i+1] = prefixSums[i] + nums[i];
        }

        int result = 0;

        for(int j=1;j<=n;j++) {
            for(int i=1;i<=j;i++) {
                if(prefixSums[j] - prefixSums[i-1] == k)
                    result++;
            }
        }

        return result;
    }
}