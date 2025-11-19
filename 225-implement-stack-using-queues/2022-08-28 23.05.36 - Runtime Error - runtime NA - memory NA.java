class MyStack {
    
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public MyStack() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue1.add(x);
    }
    
    public int pop() {
        if(queue1.size() == 1) {
            return queue1.remove();
        } else {
            while(queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }
    }
    
    public int top() {
        if(queue1.size() == 1) {
            return queue1.element();
        } else {
            while(queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            return queue1.element();
        }
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