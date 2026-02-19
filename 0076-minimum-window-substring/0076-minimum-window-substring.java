class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(sLen < tLen) return "";
        
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for(Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int required = tMap.size();
        int current = 0;

        int resLeft = -1, resRight = -1;
        int resLen = Integer.MAX_VALUE;
        int left = 0;
        for(int right = 0; right < sLen; right++) {
            Character c = s.charAt(right);
            if(tMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if(tMap.get(c).equals(windowMap.get(c))) {
                    current++;
                }
            }

            while(current == required) {
                int windowSize = right - left + 1;
                if(windowSize < resLen) {
                    resLeft = left;
                    resRight = right;
                    resLen = windowSize;
                }

                char leftChar = s.charAt(left);
                if(tMap.containsKey(leftChar)) {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                    if(windowMap.get(leftChar) < tMap.get(leftChar)) {
                        current--;
                    }
                }
                left++;
            }
        }

        System.out.println(resLeft + "," + resRight);
        return resLeft == -1 ? "" : s.substring(resLeft, resRight + 1); 
    }
}