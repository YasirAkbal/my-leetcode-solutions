class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) { return false; }
        
        short[] table1 = new short[26];
        short[] table2 = new short[26];
        
        for(int i=0;i<s.length();i++) {
            table1[s.charAt(i)-97]++;
            table2[t.charAt(i)-97]++;
        }
        
        for(int i=0;i<26;i++) {
            if(table1[i] != table2[i]) {
                return false;
            }
        }
        
        return true;
    }
}