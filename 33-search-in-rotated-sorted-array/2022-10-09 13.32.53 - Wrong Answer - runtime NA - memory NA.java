class Solution {
    public int search(int[] arr, int target) {
        final int n = arr.length;
        int left = 0;
        int right = n-1;
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            if(arr[mid] == target) {
                return mid;
            } else if(arr[left] <= arr[mid]) { //left sorted
                 if(target >= arr[left] && target < arr[right]) {
                     right = mid-1;
                 } else {
                     left = mid+1;
                 }
            } else { //arr[left] > arr[mid]; right sorted
                if(target > arr[mid] && target <= arr[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        
        return -1;
    }
}