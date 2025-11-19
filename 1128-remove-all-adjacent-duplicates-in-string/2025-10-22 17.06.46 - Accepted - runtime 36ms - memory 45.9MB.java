class Solution {
    public String removeDuplicates(String s) {
        if(s.length() <= 1) return s;
        
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}