class Solution {
    public int findMin(int[] arr) {
        final int n = arr.length;
        int min = Integer.MAX_VALUE;
        
        int left = 0;
        int right = n-1;
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            if(arr[left] <= arr[mid]) { //right sorted
                min = Math.min(min, arr[left]);
                left = mid+1;
            } else {
                min = Math.min(min, arr[mid]);
                right = mid-1;
            }
        }
        
        return min;
    }
}