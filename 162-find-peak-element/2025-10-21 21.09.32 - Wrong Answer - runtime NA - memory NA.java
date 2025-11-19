class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int left = 0, right = n-1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if((mid-1 < 0 || nums[mid] > nums[mid-1]) && (mid+1 == n || nums[mid] > nums[mid+1])) {
                return mid;
            } else if(mid-1 < 0 || nums[mid-1] > nums[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return 0;
    }
}