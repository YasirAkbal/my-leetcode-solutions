class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k <= 0) return false;
        
        final int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        int i = 0;
        for(i=0;i<Math.min(k,n);i++) {
            if(map.containsKey(nums[i])) 
                return true;
            
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        for(;i<n;i++) {
            if(map.containsKey(nums[i])) 
                return true; 
            
            if(map.get(nums[i-k]) == 1)
                map.remove(nums[i-k]);
            else
                map.put(nums[i-k], map.get(nums[i-k])-1);
            
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        return false;
    }
}