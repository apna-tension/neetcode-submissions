class Solution {
    private int[][] direction = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] vis, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int[] dir : direction) 
        dfs(grid, vis, i + dir[0], j + dir[1]);
    }
}
