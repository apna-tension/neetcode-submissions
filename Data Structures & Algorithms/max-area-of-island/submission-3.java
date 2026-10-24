class Solution {
    private int[] r;
    private int[] c;
    public int maxAreaOfIsland(int[][] grid) {
        r = new int[]{0, 1, 0, -1};
        c = new int[]{1, 0, -1, 0};
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j, m, n));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int sum = 0;
        for (int k = 0; k < 4; k++) {
            sum += dfs(grid, i+r[k], j+c[k], m, n);
        }
        return sum + 1;
    }
}
