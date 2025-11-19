class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int maxCount = 0;
        int count = 0;

        int leftIndex = 0, rightIndex = 0;
        while(rightIndex < n) {
            Character c = s.charAt(rightIndex);
            if(set.contains(c)) {
                maxCount = Math.max(maxCount, count);

                while(leftIndex < rightIndex && s.charAt(leftIndex) != c) {
                    count--;
                    set.remove(s.charAt(leftIndex));
                    leftIndex++;
                }

                while(leftIndex < rightIndex && s.charAt(leftIndex) == c) {
                    count--;
                    set.remove(s.charAt(leftIndex));
                    leftIndex++;
                }
                count = rightIndex-leftIndex+1;
            } else {
                count++;  
            }

            set.add(c);
            rightIndex++;
        }

        return Math.max(count, maxCount);
    }
}