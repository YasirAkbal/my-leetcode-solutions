class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(sLen < tLen) return "";
        
        int[] tTable = new int[52];
        
        for(int i = 0; i < tLen; i++) {
            tTable[determineIndex(t.charAt(i))]++;
        }
        
        int required = 0;
        for (int freq : tTable) {
            if (freq > 0) required++;
        }
        int formed = 0;
        
        String result = null;
        int[] windowTable = new int[52];
        int left = 0;
        for(int right = 0; right < sLen; right++) {
            Character c = s.charAt(right);
            int index = determineIndex(c);
            
            if(tTable[index] > 0) {
                windowTable[index]++;
                if (windowTable[index] == tTable[index]) {
                    formed++;
                }
            }
            
            while(formed == required) {
                int windowSize = right - left + 1;
                if (result == null || windowSize < result.length()) {
                    result = s.substring(left, right + 1);
                }
                
                int leftIndex = determineIndex(s.charAt(left));
                if (tTable[leftIndex] > 0) {
                    windowTable[leftIndex]--;
                    if (windowTable[leftIndex] < tTable[leftIndex]) {
                        formed--;
                    }
                }
                left++;
            }
        }
        
        
        return result == null ? "" : result;
    }
    
    
    private int determineIndex(Character c) {
        int index;
        
        if (c >= 'a' && c <= 'z') {
            index = c - 'a'; // 0-25
        } else {
            index = c - 'A' + 26; // 26-51
        }
        
        return index;
    }
}