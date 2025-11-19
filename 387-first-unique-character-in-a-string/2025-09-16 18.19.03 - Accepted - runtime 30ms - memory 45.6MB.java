class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> myMap = new HashMap<>();
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(myMap.containsKey(c)) {
                myMap.put(c,-1);
            } else {
                myMap.put(c,i);
            }
        }
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int index = myMap.get(c);
            if(index != -1) {
                return index;
            }
        }
        
        return -1;
    }
}