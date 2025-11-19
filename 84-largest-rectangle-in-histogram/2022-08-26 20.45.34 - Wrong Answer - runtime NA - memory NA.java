class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int max = heights[0];
        int min = heights[0];
        int lastZeroIndex = -1;
        boolean hasZero = false;
        
        for(int i=1;i<n;i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                stack.pop();
            }
            
            int curr = stack.isEmpty() ?  
            heights[i-1] == 0 ? -1 : (i+1-(hasZero ? lastZeroIndex : 0))*heights[i]
            : 
            (i-stack.peek()+1)*heights[stack.peek()];

            max = Math.max(heights[i],Math.max(max,curr));
            
            if(heights[i] > 0) {
                stack.push(i);
                min = Math.min(min,heights[i]);
            } else {
                lastZeroIndex = i;
                hasZero = true;
            }
        }
        
        int x = stack.size() == n ? heights[n/2]*(n-n/2) : -1;
        return Math.max(x,Math.max(max,min*(n-(hasZero ? lastZeroIndex+1 : 0))));
    }
}