
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;
        int mergedLen = n+m;
        int[][] mergedList = new int[mergedLen][2];
        System.arraycopy(firstList, 0, mergedList, 0, n);
        System.arraycopy(secondList, 0, mergedList, n, m);

        Arrays.sort(mergedList, (a, b) -> Double.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for(int i=0;i<mergedLen;i++) {
            while(i+1 < mergedLen && mergedList[i][1] >= mergedList[i+1][0]) {            
                result.add(new int[]{mergedList[i+1][0], Math.min(mergedList[i][1], mergedList[i+1][1])});
                i++;
            }  
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}