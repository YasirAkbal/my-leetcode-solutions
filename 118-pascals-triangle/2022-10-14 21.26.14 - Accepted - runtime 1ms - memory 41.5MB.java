class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
    
        result.add(new ArrayList<>(List.of(1)));
        if(numRows == 1) return result;
        
        result.add(new ArrayList<>(List.of(1,1)));
        if(numRows == 2) return result;
        
        List<Integer> currentRow;
        List<Integer> prevRow;
        for(int i=2;i<numRows;i++) {
            prevRow = result.get(i-1);
            currentRow = new ArrayList<>(List.of(1));
            for(int j=1;j<result.get(i-1).size();j++) {
                currentRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            currentRow.add(1);
            result.add(currentRow);
        }
    
        return result;
    }
}