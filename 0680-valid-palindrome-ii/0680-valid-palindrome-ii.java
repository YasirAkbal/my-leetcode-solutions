class Solution {
    static class Result {
        boolean isPalindrome;
        int[] indices;
        
        public Result(boolean isPalindrome, int[] indices) {
            this.isPalindrome = isPalindrome;
            this.indices = indices;
        }
    }

    public boolean validPalindrome(String s) {
        int n = s.length();
        Result result = checkIfPalindrome(s, 0, n-1);
        if(result.isPalindrome) 
            return true;
        
        return checkIfPalindrome(s, result.indices[0]+1, result.indices[1]).isPalindrome ||
            checkIfPalindrome(s, result.indices[0], result.indices[1]-1).isPalindrome;
    }

        
    private static Result checkIfPalindrome(String str, int left, int right) {
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return new Result(false, new int[]{left, right});
            }
            
            left++;
            right--;
        }
        
        return new Result(true, null);
    }
}