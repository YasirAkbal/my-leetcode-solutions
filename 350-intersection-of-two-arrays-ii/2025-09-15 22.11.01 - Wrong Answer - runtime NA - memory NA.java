class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();
        List<Integer> result = new LinkedList<>();
        
        for(int i=0;i<nums1.length;i++) {
            int count = myMap.getOrDefault(nums1[i],0) + 1;
            myMap.put(nums1[i],count);
        }
        
        for(int i=0;i<nums2.length;i++) {
            if(myMap.containsKey(nums2[i])) {
                int count = myMap.get(nums2[i]);
                
                myMap.put(nums2[i], count-1);
                result.add(nums2[i]);
                
                if(count == 0) {
                    myMap.remove(nums2[i]);
                } 
            }
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}