class Solution {
    public int climbStairs(int n) {
        int[] table = new int[n+1];
        
        int result = solve(0, n, table);
        
        return result;
    }
    
    private int solve(int x, int n, int[] table) {
        if(x < n && table[x] > 0) {
           return table[x]; 
        }
        if(x == n) {
            table[x]++;;
            return 1; 
        }
        if(x > n) { 
            return 0; 
        }
        
        return solve(x+1, n, table) + solve(x+2, n, table);
    }
}