class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        int n = nums.length;
        if(n == 0) {return result;}
        int leftMostIndex = findLeftMost(nums, target);
        if(leftMostIndex == -1) {
            return result;
        }

        result[0] = leftMostIndex;
        int left = leftMostIndex, right = n-1;

        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                if(mid + 1 < n && nums[mid+1] == target) {
                    left = mid + 1;
                } else {
                    break;
                }
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        result[1] = mid;
        return result;
    }

    private int findLeftMost(int[] nums, int target) {
        int n = nums.length;

        int left = 0, right = n-1;
        while(left < right) {
            int mid = (left + right) / 2;

            if(nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left] == target ? left : -1;
    }
}