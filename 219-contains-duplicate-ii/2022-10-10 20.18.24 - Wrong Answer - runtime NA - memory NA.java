class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        int i = 0;
        for(i=0;i<k;i++) {
            if(map.containsKey(nums[i])) 
                return true;
            
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        if(k <= n)
            return false;
        
        /*if(map.containsKey(nums[k])) 
                return true;
        map.put(nums[k], map.getOrDefault(nums[k],0)+1);

        
        int maxIndex = Math.min(2*k+1,n);
        for(;i<maxIndex;i++) {
            if(map.containsKey(nums[i])) 
                return true;
            
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }*/
        
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