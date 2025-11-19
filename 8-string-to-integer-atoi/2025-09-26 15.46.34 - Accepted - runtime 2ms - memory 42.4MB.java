class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        if(len == 0) { return 0; }
        
        int i=0;
        //skip whitespaces
        while(i < len && s.charAt(i) == ' ') {
            i++;
        }
        if(i == len) { return 0; }
        
        //determine sign
        boolean isNegative = s.charAt(i) == '-';
        if(s.charAt(i) == '-' || s.charAt(i) == '+') {
            i++;
        }
        if(i == len) { return 0; }
        
        //skip zeros
        while(i < len && s.charAt(i) == '0') {
            i++;
        }
        if(i == len) { return 0; }

        //read the digits
        int j = i;
        while(j < len && Character.isDigit(s.charAt(j))) {
            j++;
        }
        
        if(i == j) {
            return 0;
        }
        
        int num;
        try {
            num = Integer.parseInt(s.substring(i,j));
            num = isNegative ? -num : num;
        } catch(NumberFormatException e) {
            num = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        
        return num;
    }
}