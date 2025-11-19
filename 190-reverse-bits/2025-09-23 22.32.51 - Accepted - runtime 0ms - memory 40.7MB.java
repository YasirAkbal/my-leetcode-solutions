class Solution {
    public int reverseBits(int n) {
        long x = 1L << 31;
        long result = 0;
        
        while(n != 0) {
            if(n % 2 == 1) {
                result ^= x;
            }
            n /= 2;
            x /= 2;
        }
        
        return (int)result;
    }
}