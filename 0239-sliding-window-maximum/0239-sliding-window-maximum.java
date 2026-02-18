class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
    
        for(int i = 0; i < n; i++) {
            if(!deque.isEmpty() && i >= deque.getFirst() + k) {
                deque.removeFirst();
            }
      
            while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
      
            deque.addLast(i);
        
            if(i >= k - 1) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }
		
        return result;
    }
}