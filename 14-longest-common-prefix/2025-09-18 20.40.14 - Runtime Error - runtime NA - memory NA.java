class Solution {
    public String longestCommonPrefix(String[] strs) {
        int[] indexes = new int[strs.length];
        
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
                maxIndex++;
            }
            catch(ArrayIndexOutOfBoundsException exception) {
                areAllSame = false;
                System.out.println(exception);
            }

        }

        
        return strs[0].substring(0,maxIndex-1);
    }
}