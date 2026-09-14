class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, visit, i, j);
                }
            }
        }
        return 0;
    }
    private int dfs(int[][] grid, boolean[][] visit, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 1;
        if (visit[i][j]) return 0;

        visit[i][j] = true;
        int left = dfs(grid, visit, i, j-1);
        int right = dfs(grid, visit, i, j+1);
        int down = dfs(grid, visit, i+1, j);
        int up = dfs(grid, visit, i-1, j);
        return left + right + down + up;
    }
}