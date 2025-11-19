class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        //if(digits.length == 1 && digits[0] == 9) {return new int[]{1,0}; }
        //if(digits.length == 1 && digits[0] == 0) {return new int[]{1}; }
        
        int sum = digits[i] + 1;
        while(i > 0 && sum == 10) {
            digits[i] = 0;
            sum = digits[i-1] + 1;
            i--;
        }
        digits[i] = sum%10;
            
        if(i==0 && sum == 10) {
            int[] result = new int[digits.length+1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
            
        return digits;
    }
}