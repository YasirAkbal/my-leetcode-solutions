class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            map.putIfAbsent(s.charAt(i), i);
        }
        
        int right = n-1;
        int left = n-1;
        
        for(int i=n-1;i>=0;i--) {
            Character c = s.charAt(i);
            
            if(map.get(c) == left && left >= i) {
                result.add(right-left+1);
                left = right = left-1;
            } else {
                left = Math.min(left, map.get(c));
            } 
        }

        Collections.reverse(result);
        return result;
    }
}