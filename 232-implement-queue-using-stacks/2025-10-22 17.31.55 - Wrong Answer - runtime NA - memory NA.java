class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    Integer head = null;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        if(head == null) {
            head = x;
        }
        stack1.push(x);
    }
    
    public int pop() {
        if(!stack2.isEmpty()) {
            return stack2.pop();
        }

        while(!stack1.isEmpty()) {
            int x = stack1.pop();
            stack2.push(x);
        }

        int popped = stack2.pop();
        head = stack2.isEmpty() ? null : stack2.peek();
        return popped;
    }
    
    public int peek() {
        return (int)head;
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */