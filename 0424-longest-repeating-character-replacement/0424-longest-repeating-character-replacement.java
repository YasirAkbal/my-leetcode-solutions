class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(k >= n) {
            return n;
        }
        
        int[] counts = new int[26];
        
        int left = 0, right = 0;
        int result = 0;
        int maxCount = 0;
        
        while(right < n) {
            counts[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, counts[s.charAt(right) - 'A']);
            
            int windowLength = right - left + 1;
            if(windowLength <= maxCount + k) {
                result = Math.max(result, windowLength);
            } else {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            
            right++;
        }
        
        return result;
    }
}