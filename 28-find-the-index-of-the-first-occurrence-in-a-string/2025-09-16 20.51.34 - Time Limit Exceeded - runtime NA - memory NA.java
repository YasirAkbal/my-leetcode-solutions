class Solution {
    
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        int i =0, j = 0;
        while(i < n && j < m)  {
            while(i + j < n && j < m && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }
            
            if(j == m) {
                return i;
            }
            
            if(j == 0) {
                i++;
            } else {
                i += j-1;
            }
            
            j = 0;
        }
        
        return -1;
    }   
    
    /*
    //O(m*n)
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        for(int i=0;i<n;i++) {
            int j = 0;
            while(j < m && i + j < n && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }
            if(j == m) {
                return i;
            }
        }
        
        return -1;
    }*/
    
}