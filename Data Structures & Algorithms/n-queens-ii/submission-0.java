class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        backtrack(board, 0, n);
        return count;
    }
    private void backtrack(int[][] board, int i, int n) {
        if (i == n) {
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isValid(board, i, j)) {
                board[i][j] = 1;
                backtrack(board, i+1, n);
                board[i][j] = 0;
            }
        }
    }

    private boolean isValid(int[][] mat, int r, int c) {
        // for row
        for (int j = 0; j < mat.length; j++) {
            if (j == c) continue;
            if (mat[r][j] == 1) return false;
        }

        // for col
        for (int i = 0; i < mat.length; i++) {
            if (i == r) continue;
            if (mat[i][c] == 1) return false;
        }

        // for upper left diagonal
        int i = r-1; 
        int j = c-1;
        while (i >= 0 && j >= 0) {
            if (mat[i--][j--] == 1) return false;
        }

        // for upper right diagonal
        i = r-1;
        j = c+1;
        while (i >= 0 && j < mat.length) {
            if (mat[i--][j++] == 1) return false;
        }

        // for bottom left
        i = r+1;
        j = c-1;
        while (i < mat.length && j >= 0) {
            if (mat[i++][j--] == 1) return false;
        }

        // for bottom right
        i = r+1;
        j = c+1;
        while (i < mat.length && j < mat.length) {
            if (mat[i++][j++] == 1) return false;
        }
        return true;
    }
}