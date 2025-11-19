class Solution {
    public int divisorSubstrings(int num, int k) {
        int result = 0;
        int kNum = 0;
        String str = String.valueOf(num);
        final int n = str.length();
        int i;
        
        for(i=0;i<k;i++) {
            kNum = kNum*10 + Character.getNumericValue(str.charAt(i));
        }
        
        if(num % kNum == 0) 
            result++;
        
        for(;i<n;i++) {
            kNum -= (int)Math.pow(10,k-1)*Character.getNumericValue(str.charAt(i-k));
            kNum = kNum*10 + Character.getNumericValue(str.charAt(i));
            
            if(kNum != 0 && num % kNum == 0)
                result++;
        }
        
        return result;
    }
}