class Solution {
    public int[] sortedSquares(int[] nums) {
        final int n = nums.length;
        final int[] result = new int[n];
        
        int index = n-1;
        int i=0, j=n-1;
        while(i < j) {
            int absI = Math.abs(nums[i]);
            int absJ = Math.abs(nums[j]);
            
            if(absI < absJ) {
                result[index--] = absJ*absJ;
                j--;
            } else {
                result[index--] = absI*absI;
                i++;
            } 
        }

        
        return result;
    }
}