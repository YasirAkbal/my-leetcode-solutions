class Solution {
    public static int nextIndex(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0)
            result += size;
        return result;
    }
   
   public static boolean circularArrayLoop(int[] nums) {
      int n = nums.length;

      for(int i=0;i<n;i++) {
         int slow = i, fast = i;
         int direction = nums[i] > 0 ? 1 : -1;
         
         while(true) {
            int nextSlow = nextIndex(slow, nums[slow], n);
            if(direction * nums[nextSlow] <= 0 || nextSlow == slow) break;
            
            int firstStep = nextIndex(fast, nums[fast], n);
            if (direction * nums[firstStep] <= 0 || firstStep == fast) break;
            
            int secondStep = nextIndex(firstStep, nums[firstStep], n);
            if (direction * nums[secondStep] <= 0 || secondStep == firstStep) break;
            
            fast = secondStep;
            slow = nextSlow;

            if (slow == fast) 
               return true;
         }
      }
      
      return false;
   }
}