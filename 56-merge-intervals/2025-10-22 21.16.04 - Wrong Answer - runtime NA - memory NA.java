class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int left=0, right=0;
        for(int i=0;i<n-1;i++) {
            if(intervals[i+1][0] <= intervals[i][1]) {
                left = intervals[i][0];
                right = Math.max(intervals[i][1], intervals[i+1][1]);
            } else {
                merged.add(new int[] { left, right});
                left = intervals[i+1][0];
                right = intervals[i+1][1];
            }
        }

        merged.add(new int[] { left, right});

        int x = merged.size();
        int[][] result = new int[x][2];
        for(int i=0;i<x;i++) {
            result[i][0] = merged.get(i)[0];
            result[i][1] = merged.get(i)[1];
        }

        return result;
    }
}