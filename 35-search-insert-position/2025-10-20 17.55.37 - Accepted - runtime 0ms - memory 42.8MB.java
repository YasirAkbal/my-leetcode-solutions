class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(mid + 1 < n && nums[mid] <= target && nums[mid+1] > target) {
                return mid + 1;
            } else if(mid - 1 >= 0 && nums[mid] >= target && nums[mid-1] < target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}