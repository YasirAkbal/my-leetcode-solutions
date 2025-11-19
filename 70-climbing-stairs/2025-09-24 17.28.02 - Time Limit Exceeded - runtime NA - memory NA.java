class Solution {
    public int climbStairs(int n) {
        int result = solve(0, n);
        
        return result;
    }
    
    private int solve(int x, int n) {
        if(x == n) { return 1; }
        if(x > n) { return 0; }
        
        return solve(x+1, n) + solve(x+2, n);
    }
}