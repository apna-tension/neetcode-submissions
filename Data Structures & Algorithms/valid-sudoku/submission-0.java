class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> row = new HashMap<>();
        HashMap<Integer, Set<Character>> col = new HashMap<>();
        HashMap<Integer, Set<Character>> mat = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            if (i%3 == 0) {
                mat = new HashMap<>();
                for (int j = 0; j < 3; j++) mat.put(j, new HashSet<>());
            }
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (row.get(i).contains(board[i][j])) return false;
                if (col.get(j).contains(board[i][j])) return false;
                if (mat.get(j/3).contains(board[i][j])) return false;
                row.get(i).add(board[i][j]);
                col.get(j).add(board[i][j]);
                mat.get(j/3).add(board[i][j]);
            }
        }
        return true;

    }
}
