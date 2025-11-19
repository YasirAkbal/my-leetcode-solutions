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
            if(Character.isDigit(exp.charAt(i)) || (exp.charAt(i)=='-' && (i==0 || exp.charAt(i-1)=='(')))
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
        
        boolean isNeg = false;
        boolean parenthesesOpened = false;
        int i;
        for(i=0;i<exp.length();) {
            char c = exp.charAt(i);        
            
            if(c=='-' && (i==0 || exp.charAt(i+1)=='(')) {
                if(exp.charAt(i+1)=='(') {
                    parenthesesOpened = true;
                }
                i++;
                isNeg = true;
            } else if(Character.isDigit(c)) {
                String numS = parseInt(exp,i);
                i+=numS.length();
                if(isNeg || parenthesesOpened) {
                    numS = "-" + numS;
                    isNeg = false;
                }
                res.add(numS);
            } else {
                if(c == '(') {
                    stack.push(c);
                } else if(c == ')') {
                    parenthesesOpened = false;
                    while(stack.peek() != '(') {
                        res.add(Character.toString(stack.pop()));
                    }
                    stack.pop();
                } else if(stack.isEmpty()) {
                    System.out.println("eklendi = " + c);
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
        //System.out.println(postfix);
        
        int result = 0;
        for(String s: postfix) {
            boolean isDigit;
            try {
                Double.parseDouble(s);
                isDigit = true;
            } catch(NumberFormatException e) {
                isDigit = false;
            }
            
            if(isDigit) { //digit
                //System.out.println("sa = " + s);
                stack.push(s);
            } else { //operator
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                result = doCalc(num2, num1, s.charAt(0));
                
                stack.push(""+result);
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
}