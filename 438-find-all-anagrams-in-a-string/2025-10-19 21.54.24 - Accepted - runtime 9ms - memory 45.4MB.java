class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();

        int[] tableS = new int[26];
        int[] tableP = new int[26];

        for(int i=0;i<m;i++) {
            tableP[p.charAt(i)-97]++;
        }
       
        int leftIndex, rightIndex;
        for(leftIndex = 0, rightIndex = 0;rightIndex<n;rightIndex++) {
            tableS[s.charAt(rightIndex)-97]++;

            if(rightIndex - leftIndex + 1 == m) {
                if(checkIfAnagram(tableS, tableP)) 
                    result.add(leftIndex);
                tableS[s.charAt(leftIndex)-97]--;
                leftIndex++;
            }     
        }


        return result;
    }

    private static boolean checkIfAnagram(int[] table1, int[] table2) {
        for(int i=0;i<26;i++) {
            if(table1[i] != table2[i]) {
                return false;
            }
        }  
        return true;
    }
}