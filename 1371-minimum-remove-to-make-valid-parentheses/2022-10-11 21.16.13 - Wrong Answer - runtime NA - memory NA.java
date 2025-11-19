class Solution {
    public String minRemoveToMakeValid(String s) {
        final int n = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(Character c : s.toCharArray()) {
            if(c.equals(')') && stack.isEmpty())
                continue;
            else if(c.equals(')') && stack.peek().equals(')'))
                stack.pop();
            else if(c.equals(')') && stack.peek().equals('(')) {
                stack.pop();
                sb.append(')');
            }
            else if(c.equals('(')) {
                stack.push('(');
                sb.append('(');
            }      
            else
                sb.append(c);
        }
        
        return stack.isEmpty() ? sb.toString() : "";
    }
}