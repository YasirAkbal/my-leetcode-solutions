class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0) { return false; }
        if(n % 3 == 0 || n % 9 == 0) { return true; }
        long x = 3;
        int y = 1;
        
        while(n % x == 0 && n > x*x) {
            x *= x;
            y *= 2;
        }
        
        return binarySearch(n,y,y*y);
    }
    
    private boolean binarySearch(int n, int left, int right) {
        while(left <= right) {
            int mid = (left + right) / 2;
            int x = (int)Math.pow(3, mid);

            if(n < x) {
                right = mid - 1;
            } else if(n > x) {
                left = mid + 1;
            } else {
                return true;
            } 
        }

        return false;
    }
}