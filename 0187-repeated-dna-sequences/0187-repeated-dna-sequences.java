class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        int windowSize = 10;
        if(n < windowSize) { return new ArrayList<>(); }
        
        Map<Character, Integer> toIntMap = Map.of(
            'A', 0,
            'C', 1,
            'G', 2,
            'T', 3
        );

        List<Integer> encodedStr = new ArrayList<>(n);
        for(Character c : s.toCharArray()) {
            encodedStr.add(toIntMap.get(c));
        }
    
        int base = 4;
        int multiplier = 1;
        int hashVal = 0;
        
        Set<Integer> seenHashes = new HashSet<>();
        Set<String> result = new HashSet<>();

        for(int i=0;i<windowSize;i++) {
            hashVal = hashVal * base + encodedStr.get(i);
            multiplier *= base;
        }

        seenHashes.add(hashVal);

        for(int i=1;i<=n-windowSize;i++) {
            hashVal = hashVal * base - encodedStr.get(i-1) * multiplier + encodedStr.get(i + windowSize - 1);

            if(seenHashes.contains(hashVal)) {
                result.add(s.substring(i, i + windowSize));
            } else {
                seenHashes.add(hashVal);
            }
        }

        
        return new ArrayList<>(result);
    }
}