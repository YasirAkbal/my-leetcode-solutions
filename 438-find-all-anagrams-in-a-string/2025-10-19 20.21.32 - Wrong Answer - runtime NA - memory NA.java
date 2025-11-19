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

        for(int leftIndex=0, rightIndex=0;leftIndex<n-m+1;leftIndex++) {
            if(rightIndex-leftIndex+1 == m) {
                System.out.println("leftIndex = " +leftIndex + ", leftIndex  = " + leftIndex);
                if(checkIfAnagram(tableS, tableP)) {
                    result.add(leftIndex);
                }

                tableS[s.charAt(leftIndex)-97]--;
                leftIndex++;
            }

            tableS[s.charAt(leftIndex)-97]++;
            rightIndex++;
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