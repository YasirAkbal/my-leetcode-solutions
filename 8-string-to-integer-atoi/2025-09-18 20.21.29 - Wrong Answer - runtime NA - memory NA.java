class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            
            if(stack.isEmpty()) {
                
                if((c == '-' || c == '+') && i > 0 && s.charAt(i-1) != '0') {
                    System.out.println(0);
                    sign = c =='+' ? 1: -1;
                } else if(Character.isDigit(c) && c != '0') {
                    System.out.println(1);
                    stack.push(Character.getNumericValue(c));
                } else if(!Character.isDigit(c) && c != ' ') {
                    return 0;
                } else if(!Character.isDigit(c) && i > 0 && (s.charAt(i-1) == ' ' || s.charAt(i-1) == '0')) {
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