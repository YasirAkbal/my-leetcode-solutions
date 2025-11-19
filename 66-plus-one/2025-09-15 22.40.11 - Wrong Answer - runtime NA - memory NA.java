class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        if(digits.length == 1 && digits[0] == 9) {return new int[]{1,0}; }
        if(digits.length == 1 && digits[0] == 0) {return new int[]{1}; }
        
        int sum = digits[i] + 1;
        while(i > 0 && sum == 10) {
            digits[i] = 0;
            sum = digits[i-1] + 1;
            i--;
        }
        digits[i] = sum % 10;
            
        if(i==0 && digits.length > 1) {
            int[] result = new int[digits.length+1];
            System.arraycopy(digits, 0, result, 0, digits.length);
            result[digits.length] = 0;
            return result;
        }
            
        return digits;
    }
}