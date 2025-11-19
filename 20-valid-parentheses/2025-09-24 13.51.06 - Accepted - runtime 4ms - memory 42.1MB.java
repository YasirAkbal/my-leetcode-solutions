class Solution {
    private static Map<Character, Character> bracketsMap = new HashMap<>();
    
    static {
        bracketsMap.put(')', '(');
        bracketsMap.put('}', '{');
        bracketsMap.put(']', '[');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(Character c : s.toCharArray()) {
            if(stack.isEmpty()) {
                if(bracketsMap.containsKey(c)) {
                    return false;
                } else {
                    stack.push(c);
                }
            } else {
                if(bracketsMap.containsKey(c)) {
                    Character lastBracket = stack.peek();
                    if(lastBracket == bracketsMap.get(c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        
        return stack.isEmpty();
    }
}