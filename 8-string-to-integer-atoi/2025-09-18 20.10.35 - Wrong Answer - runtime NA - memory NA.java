class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        
        for(Character c : s.toCharArray()) {
            
            if(stack.isEmpty()) {
                if(c == '-' || c == '+') {
                    sign = c =='+' ? 1: -1;
                } else if(Character.isDigit(c) && c != '0') {
                    stack.push(Character.getNumericValue(c));
                } else if(!Character.isDigit(c) && c != ' ') {
                    return 0;
                }
            } else {
                if(Character.isDigit(c)) {
                    stack.push(Character.getNumericValue(c));
                } else {
                    break;
                }
            }    
        }

        int result = 0;
        int multiplier = sign;
        while(!stack.isEmpty()) {
            int num = stack.pop();
            try {
                result = Math.addExact(result, num*multiplier);
                multiplier *= 10;
            } catch(ArithmeticException e) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        
        return result;
    }
}