class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) { return false; }
        
        short[] table = new short[26];
        
        for(int i=0;i<s.length();i++) {
            table[s.charAt(i)-'a']--;
            table[t.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++) {
            if(table[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}