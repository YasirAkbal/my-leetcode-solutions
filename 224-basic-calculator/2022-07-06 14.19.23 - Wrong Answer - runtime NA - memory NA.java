class Solution {
    static HashMap<Character, Integer> precedences = new HashMap<>();
    static {
        precedences.put('*', 1);

        precedences.put('/', 1);
        
        precedences.put('+', 0);

        precedences.put('-', 0);
        
        precedences.put('(', -1);
    }
    
    public String toPostfix(String exp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder(exp.length());
        
        for(Character c: exp.toCharArray()) {
            if(c == ' ')
                continue;
            
            if(Character.isDigit(c)) {
                res.append(c);
            } else {
                if(c == '(') {
                    stack.push(c);
                } else if(c == ')') {
                    while(stack.peek() != '(') {
                        res.append(stack.pop());
                    }
                    stack.pop();
                } else if(stack.isEmpty()) {
                    stack.push(c);
                } else if(precedences.get(c) > precedences.get(stack.peek())) {
                    stack.push(c);
                } else if(precedences.get(c) <= precedences.get(stack.peek())) {
                    while(!stack.isEmpty() && precedences.get(c) <= precedences.get(stack.peek())) {
                        res.append(stack.pop());
                    }
                    stack.push(c);
                } 
            }
        }
        
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        
        return res.toString(); 
    }
    
    
    public int doCalc(int x, int y, char op) {
        int result=0;
        
        switch(op) {
            case '+':
                result = x+y;
                break;
            case '-':
                result = x-y;
                break;
            case '*':
                result = x*y;
                break;
            case '/':
                result = x/y;
                break;
            default:
                System.out.println("invalid operator");
        }
        
        return result;
    }
    
    public int calculate(String s) {
        String postfix = toPostfix(s);
        ArrayDeque<String> stack = new ArrayDeque<>();
        //System.out.println(postfix);
        
        int result = 0;
        for(Character c: postfix.toCharArray()) {
            if(Character.isDigit(c)) { //digit
                stack.push(""+c);
            } else { //operator
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                result = doCalc(num2, num1, c);
                
                stack.push(""+result);
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
}