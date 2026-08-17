class NumMatrix {
    int[][] board;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        board = new int[r+1][c+1];

        for (int i = 0; i < r; i++) {
            int prefix = 0;
            for (int j = 0; j < c; j++) {
                prefix += matrix[i][j];
                int above = board[i][j+1];
                board[i+1][j+1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        r1++;
        c1++;
        r2++;
        c2++;
        int bottomRight = board[r2][c2];
        int above = board[r1-1][c2];
        int left = board[r2][c1-1];
        int topLeft = board[r1-1][c1-1];
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */