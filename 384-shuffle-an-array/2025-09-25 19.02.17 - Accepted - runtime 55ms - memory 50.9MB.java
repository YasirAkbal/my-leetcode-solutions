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
        int leftLimit = arr.length;
        
        int[] shuffledArr = new int[n];
        while(i < n) {
            int randomIndex = rnd.nextInt(leftLimit);
            shuffledArr[i] = arr[randomIndex];
            
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[leftLimit-1];
            arr[leftLimit-1] = temp;
            
            leftLimit--;
            i++;
        }
        
        arr = shuffledArr;
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */