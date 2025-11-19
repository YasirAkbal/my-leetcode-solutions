class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i=0;i<n;i++) {
            List<Integer> triplet = findPair(nums, i, -nums[i]);
            if(!triplet.isEmpty()) {
                triplet.add(nums[i]);
                result.add(triplet);
            }
        }
        
        return result;
    }
    
    public List<Integer> findPair(int[] nums, int i, int target) {
        final List<Integer> result = new ArrayList<>();
        int left=i+1;
        int right = nums.length-1;
        
        while(left < right) {
            int pairSum = nums[left] + nums[right];
            if(pairSum < target || left == i) {
                left++;
            } else if(pairSum > target || right == i) {
                right--;
            } else {
                result.add(nums[left]);
                result.add(nums[right]);
                break;
            }
        }
        
        return result;
    }
}