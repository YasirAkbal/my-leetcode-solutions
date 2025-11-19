class Solution {
    private int[] nums;
    private int[] cumulative;
    private int cumSum;
    private int n;

    public Solution(int[] w) {
        nums = w;
        n = w.length;
        cumulative = new int[n];
        cumulative[0] = w[0];
        for(int i=1;i<n;i++) {
            cumulative[i] = cumulative[i-1] + w[i];
        }

        cumSum = cumulative[n-1];
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int randInt = rand.nextInt(cumSum);

        int left = 0, right = n;

        while(left < right) {
            int mid = (left + right) / 2;

            if(cumulative[mid] < randInt) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */