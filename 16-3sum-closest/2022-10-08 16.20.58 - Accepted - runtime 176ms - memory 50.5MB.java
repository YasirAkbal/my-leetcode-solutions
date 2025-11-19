class Solution {
    public int threeSumClosest(int[] nums, int target) {
        final int n = nums.length;
        if(n <= 3) { Arrays.stream(nums).sum(); }
        
        Arrays.sort(nums);
        
        Integer closestSum = null;
        for(int i=0;i<n;i++) {
            int left = i+1;
            int right = n-1;
            
            while(left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                
                if(threeSum < target) {
                    left++;
                } else {
                    right--;
                }
                
                if(closestSum == null 
                   || Math.abs(target-threeSum) < Math.abs(target-closestSum)) {
                    closestSum = threeSum;
                }
            }
        }
        
        return closestSum;
    }
}