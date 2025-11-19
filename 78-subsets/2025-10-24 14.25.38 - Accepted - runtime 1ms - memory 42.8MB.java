class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> candidate = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, candidate, 0, result);

        return result;
    }

    private void dfs(int[] nums, List<Integer> candidate, int deepth, List<List<Integer>> result) {
        if(deepth == nums.length) {
            result.add(new ArrayList<>(candidate));
            return;
        }

        candidate.add(nums[deepth]);
        dfs(nums, candidate, deepth+1, result);

        candidate.remove(candidate.size()-1);
        dfs(nums, candidate, deepth+1, result);
    }
}