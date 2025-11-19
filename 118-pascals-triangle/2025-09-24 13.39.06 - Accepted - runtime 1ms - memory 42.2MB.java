class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(new ArrayList<Integer>(Arrays.asList(1)));
        if(numRows == 1) { return result; }
        
        for(int i=1;i<numRows;i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            
            int j = 0;
            List<Integer> prevRow = result.get(i-1);
            while(j < i-1) {
                row.add(prevRow.get(j) + prevRow.get(j+1));
                j++;
            }
            
            row.add(1);
            
            result.add(row);
        }
        
        return result;
    }
}