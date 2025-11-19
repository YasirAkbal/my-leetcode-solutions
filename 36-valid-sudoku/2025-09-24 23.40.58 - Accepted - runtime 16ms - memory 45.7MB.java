class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Map<String, Set<Character>> subBoxes = new HashMap<>();
        
        for(int i=0;i<9;i++) {
            rows[i] = new HashSet();
            columns[i] = new HashSet();   
        }
        
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(subBoxes.get(i/3+""+j/3) == null) {
                    subBoxes.put(i/3+""+j/3, new HashSet<>());
                }
                if(rows[i].contains(board[i][j])
                  || columns[j].contains(board[i][j])
                  || subBoxes.get(i/3+""+j/3).contains(board[i][j]))
                {
                    return false;
                }
                      
                if(board[i][j] != '.')
                    rows[i].add(board[i][j]);
                if(board[i][j] != '.')
                    columns[j].add(board[i][j]);
                if(board[i][j] != '.')
                    subBoxes.get(i/3+""+j/3).add(board[i][j]);    
            }
        }
        
        return true;
    }
}