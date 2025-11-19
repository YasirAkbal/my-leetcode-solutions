class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) { return false; }
        int result = (int)s.charAt(0);
        for(int i=1;i<s.length();i++) {
            result ^= (int)s.charAt(i);
        }
        
        for(int i=0;i<t.length();i++) {
            result ^= (int)t.charAt(i);
        }
        
        return result == 0;
    }
}