class Solution {
    public int countPrimes(int n) {
        int result = 0;
        
        for(int i=2;i<n;i++) {
            if(isPrime(i)) {
                result++;
            }
        }
        
        return result;
    }
    
    private boolean isPrime(int num) {
        if(num == 0 || num == 1) { return false; }
        
        for(int i=2;i*i<=num;i++) {
            if(num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}