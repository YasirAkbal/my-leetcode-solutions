class StockSpanner {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    ArrayList<Integer> priceArr= new ArrayList<>();
    int i=0;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        priceArr.add(price);
        if(i == 0) {
            stack.push(0);
            
            i++;
            return 1;
        } else {
            while(!stack.isEmpty() && priceArr.get(stack.peek()) <= price) {
                stack.pop();
            }
            int span = stack.isEmpty() ? i+1 : i-stack.peek();
            stack.push(i);
            
            i++;
            return span;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */