class Solution {
    public int appendCharacters(String source, String target) {
        int i = 0;
        int j = 0;
        
        while(i < source.length() && j < target.length()) {
            if(source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        
        return (target.length() - j);
    }
}