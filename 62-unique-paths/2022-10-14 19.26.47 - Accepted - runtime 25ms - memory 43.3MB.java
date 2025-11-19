class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public int uniquePaths(int m, int n) {
        if(n == 1 || m == 1) return 1;
        String sr1 = ""+(m-1)+","+n;
        String sr1_2 = ""+n+","+(m-1);
        
        String sr2 = ""+m+","+(n-1);
        String sr2_2 = ""+(n-1)+","+m;
        
        int r1 = 0;
        if(map.containsKey(sr1))
            r1 += map.get(sr1);
        else if(map.containsKey(sr1_2))
            r1 += map.get(sr1_2);
        else {
            r1 += uniquePaths(m-1,n);
            map.put(sr1, r1);
            map.put(sr1_2, r1);
        }
            
        int r2 = 0;
        if(map.containsKey(sr2))
            r2 += map.get(sr2);
        else if(map.containsKey(sr2_2))
            r2 += map.get(sr2_2);
        else {
            r2 += uniquePaths(m,n-1);
            map.put(sr2, r2);
            map.put(sr2_2, r2);
        }
        
        return r1 + r2;
    }
}