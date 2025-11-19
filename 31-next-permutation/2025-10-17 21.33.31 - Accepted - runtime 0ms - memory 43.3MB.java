class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) { return; }

        int rightIndex = n-1;
        while(rightIndex > 0 && nums[rightIndex] <= nums[rightIndex-1]) {
            rightIndex--;
        }

        if(rightIndex == 0) {
            reverseArr(nums, 0);
            return;
        }

        int pivotIndex = rightIndex-1;
        rightIndex = n-1;
        while(nums[rightIndex] <= nums[pivotIndex]) {
            rightIndex--;
        }

        int temp = nums[rightIndex];
        nums[rightIndex] = nums[pivotIndex];
        nums[pivotIndex] = temp;

        reverseArr(nums, pivotIndex+1);
    }

    private void reverseArr(int[] arr, int startIndex) {
        int n = arr.length;
        for(int i=0;i<(n-startIndex)/2;i++) {
            int temp = arr[startIndex+i];
            arr[startIndex+i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }
}