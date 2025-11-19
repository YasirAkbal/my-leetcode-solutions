class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        
        for(Character c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }  
        }

        if(!stack.isEmpty())  {
            Character lastChar = stack.pop();
            if(lastChar == stack.peek()) {
                stack.pop();
            } else {
                stack.push(lastChar);
            }
        }


        String result = "";
        while(!stack.isEmpty()) {
            result += stack.pop();
        }


        return new StringBuilder(result).reverse().toString();
    }
}