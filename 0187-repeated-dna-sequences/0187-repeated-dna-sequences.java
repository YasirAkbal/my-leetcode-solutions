class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();

        if(n < 10) {
            return new ArrayList();
        }
        
        Map<String, Integer> countsMap = new HashMap<>();
        int left = 0, right = 10;
        
        String slice;
        while(right <= n) {
            slice = s.substring(left, right);
            countsMap.put(slice, countsMap.getOrDefault(slice, 0) + 1);
            
            left++;
            right++;
        }
        
        List<String> result  = countsMap.entrySet().stream()
                    .filter(e -> e.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .toList();
        
        return result;
    }
}