class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currentCandidates = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        dfs(candidates, target, 0, currentCandidates, 0, result);

        return result;
    }

    private void dfs(int[] nums, int target, int currSum, List<Integer> currentCandidates, int i, List<List<Integer>> result) {
        if(currSum == target) { 
            result.add(new ArrayList<Integer>(currentCandidates));
        }
        if(currSum > target) { return ; }

        for(int j=i;j<nums.length;j++) {
            currentCandidates.add(nums[j]);
            dfs(nums, target, currSum + nums[j], currentCandidates, j, result);
            currentCandidates.remove(currentCandidates.size()-1);
        }
    }
}