class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length(), s2Len = s2.length();
        int[] s1Table = new int[26];
        
        for(Character c: s1.toCharArray()) {
            s1Table[c - 'a']++;
        }
        
        int[] windowTable = new int[26];
        for(int i = 0; i < s2Len; i++) {
            windowTable[s2.charAt(i) - 'a']++;
            
            if(i >= s1Len) {
                windowTable[s2.charAt(i - s1Len) - 'a']--;
            }
            
            if(checkIfAnagram(s1Table, windowTable))
                return true;
        }
        
        return false;
    }

    private static boolean checkIfAnagram(int[] table1, int[] table2) {
        int n = table1.length;
        
        for(int i = 0; i < n; i++) {
            if(table1[i] != table2[i])
                return false;
        }
        
        return true;
    }
}