class Solution {
    public int hammingDistance(int x, int y) {
        int xorResult = x ^ y;
        
        int result = 0;
        
        while(xorResult != 0) {
            xorResult &= xorResult - 1;
            
            result++;
        }
        
        return result;
    }
}