class Solution {
    public int[] twoSum(int[] nums, int target) {
        final int n = nums.length;
        final int[] result = new int[2];
        final Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++) {
            int diff = target-nums[i];
            
            if(map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
                break;
            }
            
            map.put(nums[i], i);
        }
        
        return result;
    }
}