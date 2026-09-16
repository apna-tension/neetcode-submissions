class Solution {
    private int[] r;
    private int[] c;
    public int maxAreaOfIsland(int[][] grid) {
        r = new int[]{0, 1, 0, -1};
        c = new int[]{1, 0, -1, 0};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    max = Math.max(max, dfs(grid, i, j, m, n, visit));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visit) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visit[i][j]) return 0;

        visit[i][j] = true;
        int sum = 0;
        for (int k = 0; k < 4; k++) {
            sum += dfs(grid, i+r[k], j+c[k], m, n, visit);
        }
        return sum + 1;
    }
}
