class Solution {
    public int pivotIndex(int[] arr) {
        final int n = arr.length;
        int[] rightSum = new int[n];
        rightSum[n-1] = arr[n-1];

        for(int i=n-2;i>=0;i--) {
            rightSum[i] += rightSum[i+1] + arr[i];
        }
        
        int leftSum = 0;
        
        for(int i=0;i<n;i++) {
            leftSum += arr[i];
            
            if(leftSum == rightSum[i])
                return i;   
        }
        
        return -1;
    }
}