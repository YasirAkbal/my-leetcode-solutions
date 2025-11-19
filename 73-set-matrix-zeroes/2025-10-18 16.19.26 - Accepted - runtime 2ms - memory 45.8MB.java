class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                } 
            }
        }

        for(Integer rowIndex : rows) {
            setRowToZero(matrix, rowIndex);
        }

        for(Integer columnIndex : columns) {
            setColumnToZero(matrix, columnIndex);
        }
    }


    /*
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=count;j<n;j++) {
                if(matrix[i][j] == 0) {
                    if(!rows.contains(i)) {
                        setRowToZero(matrix, i); 
                        rows.add(i);
                    } 

                    if(!columns.contains(j)) {
                        setColumnToZero(matrix, j);
                        columns.add(j);
                        count++;
                    }
                } 
            }
        }
    }

    */
    private void setRowToZero(int[][] matrix, int rowIndex) {
        int n = matrix[0].length;

        for(int i=0;i<n;i++) {
            matrix[rowIndex][i] = 0;
        }
    }

    private void setColumnToZero(int[][] matrix, int columnIndex) {
        int m = matrix.length;

        for(int i=0;i<m;i++) {
            matrix[i][columnIndex] = 0;
        }
    }
}