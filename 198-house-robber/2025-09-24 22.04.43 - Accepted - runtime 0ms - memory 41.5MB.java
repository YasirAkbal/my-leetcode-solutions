class Solution {
    public int rob(int[] nums) {
        int[] table = new int[nums.length];
        Arrays.fill(table, -1);
        
        return recursive(nums,0,0,table);
    }
    
    private int recursive(int[] nums, int i, int sum, int[] table) {
        if(i >= nums.length) { return sum; }
        if(table[i] != -1) { return table[i] + sum; }
        
        int result = Math.max(recursive(nums, i+1, sum, table), recursive(nums, i+2, sum+nums[i], table));
        table[i] = result;
        return result;
    }
}