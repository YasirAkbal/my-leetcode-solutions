class Solution {
    public int removeElement(int[] nums, int val) {
        int read = 0;
        int write = 0;
        int n = nums.length;
        
        while(read < n && nums[read] != val) {
            read++;
            write++;
        }
        
        while(read < n) {
            if(nums[read] != val) {
                int temp = nums[read];
                nums[read] = nums[write];
                nums[write] = temp;
                write++;
            }
            
            read++;
        }
        
        return write;
    }
}