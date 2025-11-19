class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int max = heights[0];
        int min = heights[0];
        
        for(int i=1;i<n;i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                stack.pop();
            }
            int curr = stack.isEmpty() ? (i+1)*heights[i] : 
            (i-stack.peek()+1)*heights[stack.peek()];

            max = Math.max(heights[i],Math.max(max,curr));
            min = Math.min(min,heights[i]);
            stack.push(i);
        }
        
        int x = stack.size() == n ? heights[n/2]*(n-n/2) : -1;
        return Math.max(x,Math.max(max,min*n));
    }
}