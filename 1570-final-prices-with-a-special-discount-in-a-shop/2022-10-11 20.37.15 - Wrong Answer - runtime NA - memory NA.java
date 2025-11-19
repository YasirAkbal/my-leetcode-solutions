class Solution {
    public int[] finalPrices(int[] prices) {
        final int n = prices.length;
        int min = 0;
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && stack.peek() > i) {
                int popped = stack.pop();
                if(prices[popped] <= prices[i])
                    min = prices[popped];
            }     
            
            stack.push(i);
            result[i] = Math.max(0,prices[i]-min);
        }
        
        return result;
    }
}