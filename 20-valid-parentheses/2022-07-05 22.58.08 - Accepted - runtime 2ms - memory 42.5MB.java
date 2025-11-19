class Solution {
    static HashMap<Character, Character> brackets = new HashMap<>();
    
    static {
        brackets.put('{','}');
        brackets.put('[',']');
        brackets.put('(',')');
    }
    
    public boolean isValid(String s) {
        char c;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++) {
            c = s.charAt(i);
            if(brackets.containsKey(c)) {
                stack.push(c);
            } else if(stack.isEmpty()) {
                return false;
            } else if(brackets.getOrDefault(stack.peek(),null) == c) {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}