class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<n-2;i++) {
            if(nums[i] > 0) {
                return result;
            }

            if(i == 0 || nums[i] != nums[i-1]) {
                int leftIndex = i + 1;
                int rightIndex = n - 1;
                
                while(leftIndex < rightIndex) {
                    int sum = nums[i] + nums[leftIndex] + nums[rightIndex];

                    if(sum < 0) {
                        leftIndex++;
                    } else if(sum > 0) {
                        rightIndex--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));

                        leftIndex++;
                        rightIndex--;

                        while(leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex-1]) leftIndex++;
                        while(leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex+1]) rightIndex--;
                    }
                }
            }
        }

        return result;
    }
}