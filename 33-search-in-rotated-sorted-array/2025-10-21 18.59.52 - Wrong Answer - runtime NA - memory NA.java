class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0, right = n-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                if(mid + 1 < n && nums[mid+1] < nums[mid]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            } else { //arr[mid] < target
                if(mid - 1 >= 0 && nums[mid-1] < nums[mid]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}