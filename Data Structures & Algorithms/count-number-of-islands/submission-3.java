class Solution {
    public int numIslands(char[][] grid) {
        // boolean[][] visit = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    cover(grid, i, j);
                }
            }
        }
        return count;
    }

    private void cover(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == '0') return;

        grid[i][j] = '0';
        cover(grid, i+1, j);
        cover(grid, i, j+1);
        cover(grid, i-1, j);
        cover(grid, i, j-1);
    }
}
