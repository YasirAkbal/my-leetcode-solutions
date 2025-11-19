class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        
        int abs = Math.abs(n);
        
        double pow = 1;
        double temp = x;

        while(abs > 0) {
            if(abs%2 == 1)
                pow *= temp;
            
            temp *= temp;
            abs /= 2;
        }
        
        return n > 0 ? pow : 1/pow;
    }
}