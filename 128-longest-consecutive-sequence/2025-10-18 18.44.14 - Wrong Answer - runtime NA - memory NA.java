class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            hashMap.put(nums[i], 0);
        }

        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(hashMap.containsKey(nums[i])) {
                int count = 1;
                int j = 0;
                while(hashMap.containsKey(nums[i]+j+1)) {
                    hashMap.remove(nums[i]+j+1);
                    j++;
                }
                count += j;

                j = 0;
                while(hashMap.containsKey(nums[i]-j-1)) {
                    hashMap.remove(nums[i]-j-1);
                    j++;
                }

                count += j;

                maxLen = Math.max(count, maxLen);
            }
        }

        return maxLen;
    }
}