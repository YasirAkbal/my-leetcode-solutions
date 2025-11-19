class Solution {
    /* benim ilk çözüm
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
    } */
    
    public int findMin(int[] arr) {
        final int n = arr.length;
        
        if(n == 1) return arr[0];
        
        int left = 0;
        int right = n-1;
        
        if(arr[right] > arr[left]) return arr[0];
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            if(arr[mid] > arr[mid+1]) return arr[mid+1];
            if(arr[mid-1] > arr[mid]) return arr[mid];
            
            if(arr[mid] > arr[0]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return Integer.MAX_VALUE;
    }
}