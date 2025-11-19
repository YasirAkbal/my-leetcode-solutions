class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        
        int currentIndex = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] != nums[i+1]) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }
        
        return currentIndex + 1;
    }
}