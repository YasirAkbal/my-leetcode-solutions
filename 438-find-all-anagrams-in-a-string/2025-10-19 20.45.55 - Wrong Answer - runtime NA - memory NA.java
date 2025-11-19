class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();

        int[] tableS = new int[26];
        int[] tableP = new int[26];

        for(int i=0;i<m;i++) {
            tableS[s.charAt(i)-97]++;
            tableP[p.charAt(i)-97]++;
        }

        if(checkIfAnagram(tableS, tableP)) {
            result.add(0);
        }

        for(int i=m;i<n;i++) {
            if(checkIfAnagram(tableS, tableP)) {
                result.add(i-m);
            }

            tableS[s.charAt(i)-97]++;
            tableS[s.charAt(i-m)-97]--;
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