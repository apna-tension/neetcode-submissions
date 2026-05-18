class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                boolean is = exist(board, i, j, word, 0, visit);
                if (is) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int r, int c, String word, int i, boolean[][] visit) {
        if (i >= word.length()) return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return false;
        if (board[r][c] != word.charAt(i) || visit[r][c]) return false;
        visit[r][c] = true;
        boolean left = exist(board, r, c-1, word, i+1, visit);
        boolean right = exist(board, r, c+1, word, i+1, visit);
        boolean up = exist(board, r-1, c, word, i+1, visit);
        boolean down = exist(board, r+1, c, word, i+1, visit);
        visit[r][c] = false;
        return left || right || up || down;
    }
}
