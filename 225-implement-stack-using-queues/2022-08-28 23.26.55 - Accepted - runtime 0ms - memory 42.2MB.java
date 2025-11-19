class MyStack {
    
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public MyStack() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(x);
        } else if(queue1.isEmpty()) {
            queue2.add(x);
        } else if(queue2.isEmpty()) {
            queue1.add(x);
        }
    }
    
    public int pop() {
        if(queue1.isEmpty()) {
            transfer(queue2,queue1);
            return queue2.remove();
        } else {
            transfer(queue1,queue2);
            return queue1.remove();
        }
    }
    
    private void transfer(Queue<Integer> q1, Queue<Integer> q2) {
        while(q1.size() > 1) {
            q2.add(q1.remove());
        }
    }
    
    public int top() {
        int val;
        if(queue1.isEmpty()) {
            transfer(queue2,queue1);
            val =  queue2.element();
            queue1.add(queue2.remove());
        } else {
            transfer(queue1,queue2);
            val =  queue1.element();
            queue2.add(queue1.remove());
        }
        
        return val;
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */