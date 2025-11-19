class Solution {
    
    public int climbStairs(int n) {
        int[] table = new int[n+1];
        table[n] = 1;
        table[n-1] = 1;
        
        for(int i=n-2;i>=0;i--) {
            table[i] = table[i+1] + table[i+2];
        }
        
        return table[0];
    }
    
    /*public int climbStairs(int n) {
        int[] table = new int[n+1];
        
        int result = solve(0, n, table);
        
        return result;
    }
    
    private int solve(int x, int n, int[] table) {
        if(x > n) { 
            return 0; 
        }
        if(x <= n && table[x] != 0) {
            return table[x];
        }
        
        if(x == n) {
            table[x]++;
            return 1; 
        }

        if(x+1 <= n)
            table[x] += table[x+1];
        if(x+2 <= n)
            table[x] += table[x+2];
        
        return solve(x+1, n, table) + solve(x+2, n, table);
    }*/
    
    
}