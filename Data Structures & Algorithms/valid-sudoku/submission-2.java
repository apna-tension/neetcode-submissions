class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rwMap = new HashMap<>();
        Map<Integer, Set<Character>> clMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rwMap.put(i, new HashSet<>());
            clMap.put(i, new HashSet<>());
        }

        Map<Integer, Set<Character>> matMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                matMap = new HashMap<>();
                for (int j = 0; j < 3; j++) {
                    matMap.put(j, new HashSet<>());
                }
            }

            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (!rwMap.get(i).add(board[i][j])) return false;
                if (!clMap.get(j).add(board[i][j])) return false;
                if (!matMap.get(j/3).add(board[i][j])) return false;
            }

        }

        return true;
    }
}
