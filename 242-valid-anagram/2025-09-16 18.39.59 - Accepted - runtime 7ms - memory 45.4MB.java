class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) { return false; }
        
        short[] table1 = new short[Short.MAX_VALUE];
        short[] table2 = new short[Short.MAX_VALUE];
        
        for(int i=0;i<s.length();i++) {
            table1[s.charAt(i)]++;
            table2[t.charAt(i)]++;
        }
        
        for(int i=0;i<s.length();i++) {
            if(table1[s.charAt(i)] != table2[s.charAt(i)]) {
                return false;
            }
        }
        
        return true;
    }
}