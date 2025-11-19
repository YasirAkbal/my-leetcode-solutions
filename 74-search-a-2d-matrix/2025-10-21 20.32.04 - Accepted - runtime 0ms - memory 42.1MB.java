class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0, right = n-1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(matrix[mid][0] <= target && matrix[mid][m-1] >= target) {
                return binarySearch(matrix[mid], target) != -1;
            } else if(target < matrix[mid][0]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return false;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return -1;
    }
}