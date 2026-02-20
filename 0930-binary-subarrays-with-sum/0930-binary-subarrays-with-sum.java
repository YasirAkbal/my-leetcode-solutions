class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        int result = 0;
        
        int sum = 0;
        for(int num: nums) {
            sum += num;
            result += countMap.getOrDefault(sum - goal, 0);
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}