class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int maxCount = Integer.MIN_VALUE;
        int count = 0;

        int leftIndex = 0, rightIndex = 0;
        while(rightIndex < n) {
            Character c = s.charAt(rightIndex);
            if(set.contains(c)) {
                maxCount = Math.max(maxCount, count);

                while(leftIndex < n && s.charAt(leftIndex) != c) {
                    count--;
                    set.remove(s.charAt(leftIndex));
                    leftIndex++;
                }
            } else {
                count++;  
            }

            set.add(c);
            rightIndex++;
        }

        return maxCount;
    }
}