class Solution {
    public int countGoodSubstrings(String s) {
        final int n = s.length();
        if(n < 3) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        
        for(int i=0;i<Math.min(n,3);i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(int i=3;i<n;i++) {
            if(map.size() == 3)
                result++;
            
            Character firstChar = s.charAt(i-3);
            Character newChar = s.charAt(i);
            
            if(map.get(firstChar) == 1)
                map.remove(firstChar);
            else
                map.put(firstChar, map.get(firstChar)-1);
            
            map.put(newChar, map.getOrDefault(newChar,0)+1);
        }
        
        if(map.size() == 3) result++;
        
        return result;
    }
}