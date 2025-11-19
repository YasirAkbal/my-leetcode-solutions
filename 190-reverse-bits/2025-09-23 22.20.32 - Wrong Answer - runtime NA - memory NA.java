class Solution {
    public int reverseBits(int n) {
        int x = 0x80000000;
        int result = 0;
        
        while(n != 0) {
            if(n % 2 == 0) {
                result ^= x;
            }
            n /= 2;
            x = x >>> 1;
        }
        
        return result;
    }
}