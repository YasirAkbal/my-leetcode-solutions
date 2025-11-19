class Solution {
    private int[] originalArr;
    private int[] arr;
    
    public Solution(int[] nums) {
        arr = nums;
        originalArr = nums.clone();
    }
    
    public int[] reset() {
        arr = originalArr.clone();
        return arr;
    }
    
    public int[] shuffle() {
        Random rnd = new Random();
        int i = 0;
        int n = arr.length;
        int rightLimit = arr.length;
        
        while(i < n) {
            int randomIndex = rnd.nextInt(rightLimit);
            
            int temp = arr[rightLimit-1];
            arr[rightLimit-1] = arr[randomIndex];
            arr[randomIndex] = temp;
            
            rightLimit--;
            i++;
        }
        
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */