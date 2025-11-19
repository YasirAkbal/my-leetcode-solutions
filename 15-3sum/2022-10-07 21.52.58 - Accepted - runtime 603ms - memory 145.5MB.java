class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final int n = nums.length;
        Set<List<Integer>> resultSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        int left, right;
        for(int i=0;i<n;i++) {
            left = i+1;
            right = n-1;
            
            while(left < right) {
                int tripletSum = nums[i] + nums[left] + nums[right];
                
                if(tripletSum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    resultSet.add(temp);
                    left++; right--;
                } else if(tripletSum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        

        
        return new ArrayList<>(resultSet);
    }
    
}