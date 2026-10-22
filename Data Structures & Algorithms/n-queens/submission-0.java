class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> list = new ArrayList<>();
        backtrack(board, 0, n, list);
        return list;
    }

    private void backtrack(int[][] board, int i, int n, List<List<String>> list) {
        if (i == n) {
            List<String> ds = new ArrayList<>();
            for (int[] arr : board) {
                StringBuilder sb = new StringBuilder();
                for (int ele : arr) {
                    if (ele == 0) sb.append('.');
                    else sb.append('Q');
                }
                ds.add(sb.toString());
            }
            list.add(new ArrayList<>(ds));
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isValid(board, i, j)) {
                board[i][j] = 1;
                backtrack(board, i+1, n, list);
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
