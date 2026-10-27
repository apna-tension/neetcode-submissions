class Solution {
    int[] row = new int[]{-1, 0, 1, 0};
    int[] col = new int[]{0, -1, 0, 1};
    public void solve(char[][] board) {

        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) && board[i][j] == 'O') {
                        fill(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }

    private void fill(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 'X' || board[i][j] == '1') return;
        board[i][j] = '1';

        for (int idx = 0; idx < 4; idx++) {
            int r = i + row[idx];
            int c = j + col[idx];
            fill(board, r, c);
        }
    }

    // private boolean isRegion(char[][] board, int i, int j, boolean[][] vis) {
    //     if (i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) {
    //         if (board[i][j] == 'O') return false;
    //         return true;
    //     } 
    //     if (vis[i][j] || board[i][j] == 'X') return true;

    //     boolean flag = true;
    //     for (int idx = 0; idx < 4; idx++) {
    //         int r = i + row[idx];
    //         int c = j + col[idx];

    //         vis[r][c] = true;
    //         flag = flag && isRegion(board, r, c, vis);
    //     }

    //     return flag;
    // }
}
