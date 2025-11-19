class Solution {
    public void rotate(int[] nums, int k) {
        //O(n) extra space
        int len = nums.length;
        if(k >= len) {
            k = len % k;
        }
        int[] result = new int[len];
        int index = 0;
        
        for(int i=len-k;i<len;i++) {
            result[index] = nums[i];
            index++;
        }
        
        for(int i=0;i<len-k;i++) {
            result[index] = nums[i];
            index++;
        }
        
        for(int i=0;i<len;i++) {
            nums[i] = result[i];
        }
    }
}