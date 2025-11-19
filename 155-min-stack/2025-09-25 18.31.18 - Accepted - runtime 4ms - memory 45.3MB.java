class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> mins = new Stack<>();
    
    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
        int minValueInMins = mins.isEmpty() ? val : Math.min(val, mins.peek());
        mins.push(minValueInMins);
    }
    
    public void pop() {
        stack.pop();
        mins.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */