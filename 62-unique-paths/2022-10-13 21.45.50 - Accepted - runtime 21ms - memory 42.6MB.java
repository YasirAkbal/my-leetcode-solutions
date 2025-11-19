class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public int uniquePaths(int m, int n) {
        if(n == 1 || m == 1) return 1;
        
        int r1 = map.containsKey(""+(m-1)+","+n) ? map.get(""+(m-1)+","+n) : uniquePaths(m-1,n);
        map.put(""+(m-1)+","+n, r1);
        
        int r2 = map.containsKey(""+m+","+(n-1)) ? map.get(""+m+","+(n-1)) : uniquePaths(m,n-1);
        map.put(""+m+","+(n-1), r2);
        
        return r1 + r2;
    }
}