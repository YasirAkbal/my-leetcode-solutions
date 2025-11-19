class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean hasFirstRowZeros = false;
        boolean hasFirstColumnZeros = false;

        for(int i=0;i<n;i++) {
            if(matrix[0][i] == 0) {
                hasFirstRowZeros = true;
                break;
            }
        }

        for(int i=0;i<m;i++) {
            if(matrix[i][0] == 0) {
                hasFirstColumnZeros = true;
                break;
            }
        }


        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(hasFirstRowZeros) {
            for(int i=0;i<n;i++) {
                matrix[0][i] = 0;
            }
        }

        if(hasFirstColumnZeros) {
            for(int i=0;i<m;i++) {
                matrix[i][0] = 0;
            }
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
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                } 
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                } 
            }
        }
    }

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
    */
}