class Solution {
    public String longestCommonPrefix(String[] strs) {  
        if(strs.length == 1) { return strs[0]; }
        int maxIndex = 0;
        boolean areAllSame = true;
        
        while(areAllSame) {
            try {
                Character c = strs[0].charAt(maxIndex);
                for(int i=1;i<strs.length;i++) {
                    if(c != strs[i].charAt(maxIndex)) {
                        areAllSame = false;
                        break;
                    }
                }
                if(areAllSame) {
                    maxIndex++;
                }
            }
            catch(StringIndexOutOfBoundsException exception) {
                areAllSame = false;
            }

        }

        return strs[0].length() > maxIndex ? strs[0].substring(0,maxIndex) : "";
    }
}