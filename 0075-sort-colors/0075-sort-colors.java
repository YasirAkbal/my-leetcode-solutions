class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int leftIndex = 0;
        int rightIndex = n - 1;
        int i = 0;
        
        while(i <= rightIndex) {
            if(nums[i] == 0) {
                swapTwoIndices(nums, i, leftIndex);
                leftIndex++;
                i++;
            } else if(nums[i] == 2) {
                swapTwoIndices(nums, i, rightIndex);
                rightIndex--;
            } else { //nums[i] == 1
                i++;
            }
        }
    }

    private static void swapTwoIndices(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}