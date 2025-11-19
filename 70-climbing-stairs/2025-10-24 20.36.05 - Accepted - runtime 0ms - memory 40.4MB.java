class Solution {
    
    public int climbStairs(int n) {
        if(n <= 2) { return n; }
        int oneStepsBefore = 2, twoStepsBefore = 1;

        for(int i=3;i<=n;i++) {
            int current = oneStepsBefore + twoStepsBefore;
            twoStepsBefore = oneStepsBefore;
            oneStepsBefore = current;
        }
        
        return oneStepsBefore;
    }


    //tabulation
    /*public int climbStairs(int n) {
        int[] table = new int[n+1];
        table[n] = 1;
        table[n-1] = 1;
        
        for(int i=n-2;i>=0;i--) {
            table[i] = table[i+1] + table[i+2];
        }
        
        return table[0];
    }*/
    
    
    //memoization
    /*public int climbStairs(int n) {
        int[] table = new int[n+1];
        Arrays.fill(table, -1);
        
        int result = solve(n, table);
        
        return result;
    }
    
    private int solve(int n, int[] table) {
        if(n == 0 || n == 1)
            return 1;
        
        if(table[n] != -1)
            return table[n];
        
        return table[n] = solve(n-1, table) + solve(n-2, table);
    }*/
    
    
}