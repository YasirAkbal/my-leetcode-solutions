class Solution {
    public boolean isPowerOfThree(int n) {
        double log3_n = Math.log(n) / Math.log(3);
        
        if(log3_n == (int)log3_n) {
            return true;
        }
        
        return false;
    }
}