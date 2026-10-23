class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) count += dfs(grid, i, j, visit);
            }
        } 
        return count;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visit) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) return 1;
        if (visit[i][j]) return 0;

        visit[i][j] = true;
        int left = dfs(grid, i, j-1, visit);
        int right = dfs(grid, i, j+1, visit);
        int up = dfs(grid, i-1, j, visit);
        int down = dfs(grid, i+1, j, visit);
        return left + right + up + down;
    }
}