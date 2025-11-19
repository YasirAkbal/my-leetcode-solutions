class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) { return false; }
        int result1 = (int)s.charAt(0);
        for(int i=1;i<s.length();i++) {
            result1 ^= (int)s.charAt(i);
        }
        
        int result2 = (int)s.charAt(0);
        for(int i=0;i<t.length();i++) {
            result2 ^= (int)t.charAt(i);
        }
        
        if(result1 == 0 && result2 == 0) { return false; }
        
        return (result1 ^ result2) == 0;
    }
}