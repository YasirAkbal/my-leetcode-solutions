class Solution {
    public String reverseWords(String sentence) {
        int sentenceSize = sentence.length();
        
        StringBuilder sb = new StringBuilder();
        int right = sentenceSize-1;
        int left = sentenceSize-1;
        while(left >= 0) {
            while(left >= 0 && sentence.charAt(left) == ' ') {
                left--;
                right--;
            }
            
            while(left >= 0 && sentence.charAt(left) != ' ') {
                left--;
            }
            
            for(int i=left+1;i<=right;i++) {
                sb.append(sentence.charAt(i));
            }
            
            while(left >= 0 && sentence.charAt(left) == ' ') {
                left--;
            }
            
            if(left >= 0) {
                sb.append(' ');
            }
            
            right = left;
        }
        
        return sb.toString();
    }
}