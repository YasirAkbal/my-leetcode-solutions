class Solution {
    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        
        char[] chars = s.toCharArray();
        int result = 0 ;
        
        while(left < right) {
            if(chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                char pivot = chars[left];
                int i = right;
                
                while(i > left && chars[i] != pivot) {
                    i--;
                }
                
                if(i == left) {
                    result += n / 2 - i;
                    left++;
                } else {
                    for(int j=i;j<right;j++) {
                        char temp = chars[j];
                        chars[j] = chars[j+1];
                        chars[j+1] = temp;
                        
                        result++;
                    }
                    
                    left++;
                    right--;
                }
            }
        }
        
        return result;
    }
}