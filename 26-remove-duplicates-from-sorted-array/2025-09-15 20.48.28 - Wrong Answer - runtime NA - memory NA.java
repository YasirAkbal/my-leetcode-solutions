class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        
        int currentIndex = 1;
        for(int i=1;i<nums.length-1;i++) {
            if(nums[i] != nums[i+1]) {
                nums[currentIndex] = nums[i+1];
                currentIndex++;
            }
        }
        
        return currentIndex;
    }
}