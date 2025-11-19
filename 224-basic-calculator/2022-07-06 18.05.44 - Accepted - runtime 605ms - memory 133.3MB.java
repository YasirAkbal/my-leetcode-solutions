class Solution {
    static HashMap<Character, Integer> precedences = new HashMap<>();
    static {
        precedences.put('*', 1);

        precedences.put('/', 1);
        
        precedences.put('+', 0);

        precedences.put('-', 0);
        
        precedences.put('(', -1);
    }
    
    String parseInt(String exp, int start) {
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<exp.length();i++) {
            if(Character.isDigit(exp.charAt(i)))
            {
                sb.append(exp.charAt(i));
            }
            else
               break;
        }
        return sb.toString();
    }
    
    public ArrayList<String> toPostfix(String exp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayList<String> res = new ArrayList<>();

        int i;
        for(i=0;i<exp.length();) {
            char c = exp.charAt(i);        
            
             if(Character.isDigit(c)) {
                String numS = parseInt(exp,i);
                i+=numS.length();

                res.add(numS);
            } else {
                if(c == '-' && (i == 0 || 
                                (i > 1 && exp.charAt(i-2) != '(' && precedences.containsKey(exp.charAt(i-2))) &&                            !Character.isDigit(exp.charAt(i-1)))) {
                    res.add("-1");
                    stack.push('*');
                }
                else if(c == '(') {
                    stack.push(c);
                } else if(c == ')') {
                    while(stack.peek() != '(') {
                        res.add(Character.toString(stack.pop()));
                    }
                    stack.pop();
                } else if(stack.isEmpty()) {
                    stack.push(c);
                } else if(precedences.get(c) > precedences.get(stack.peek())) {
                    stack.push(c);
                } else if(precedences.get(c) <= precedences.get(stack.peek())) {
                    while(!stack.isEmpty() && precedences.get(c) <= precedences.get(stack.peek())) {
                        res.add(Character.toString(stack.pop()));
                    }
                    stack.push(c);
                } 
                i++;
            }
        }
        
        while(!stack.isEmpty()) {
            res.add(Character.toString(stack.pop()));
        }
        
        return res; 
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
    
    public int calculate(String exp) {
        exp = exp.replaceAll("\\s+","");
        ArrayList<String> postfix = toPostfix(exp);
        ArrayDeque<String> stack = new ArrayDeque<>();

        int sum = 0;
        for(String s: postfix) {
            boolean isDigit;
            try {
                Double.parseDouble(s);
                isDigit = true;
            } catch(NumberFormatException e) {
                isDigit = false;
            }
            
            if(isDigit) { //digit
                stack.push(s);
            } else { //operator
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                sum = doCalc(num2, num1, s.charAt(0));
                
                stack.push(""+sum);
            }
        }
        
        int result = 0;
        while(!stack.isEmpty()) {
            result += Integer.parseInt(stack.pop());  
        }
        return result;
    }
}