class Solution {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 1) { return false; }
        
        Set<Integer> mySet = new HashSet<Integer>();
        for(int i=0;i<len;i++) {
            if(mySet.contains(nums[i])) {
                return true;
            } else {
                mySet.add(nums[i]);
            }
        }
        
        return false;
    }
}