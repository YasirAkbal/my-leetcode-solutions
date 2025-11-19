class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        int i = 0, j = nums.length-1;
        
        while(i < j) {
            int pairSum = nums[i] + nums[j];
            
            if(pairSum == target) {
                result[0] = i+1;
                result[1] = j+1;
                break;
            }
            
            if(pairSum < target)
                i++;
            else
                j--;
        }
        
        return result;
    }
}