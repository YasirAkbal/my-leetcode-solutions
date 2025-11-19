class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mySet = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++) {
            if(mySet.containsKey(target-nums[i])) {
                return new int[]{i,mySet.get(target-nums[i])};
            } else {
                mySet.put(nums[i],i);
            }
        }
        
        return nums;
    }
}