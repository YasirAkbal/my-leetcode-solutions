class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        
        if(digits[i] != 9){
            digits[i]++;
            return digits;
        } else {
            int sum = digits[i] + 1;
            while(i > 0 && sum == 10) {
                digits[i] = 0;
                sum = digits[i-1] + 1;
                i--;
            }
            digits[i] = (digits[i] + 1) % 10;
            
            if(i==0) {
                int[] result = new int[digits.length+1];
                System.arraycopy(digits, 0, result, 0, digits.length);
                result[digits.length] = 0;
                return result;
            }
            
            return digits;
        }
    }
}