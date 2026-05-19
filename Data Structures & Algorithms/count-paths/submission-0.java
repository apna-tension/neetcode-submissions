class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];

        return path(m-1, n-1, m, n, dp);
    }

    private int path(int r, int c, int m, int n, Integer[][] dp) {
        if (r >= m || c >= n || r < 0 || c < 0) return 0;
        if (r == 0 && c == 0) return 1;
        if (dp[r][c] != null) return dp[r][c];

        int up = path(r-1, c, m, n, dp);
        int left = path(r, c-1, m, n, dp);

        return dp[r][c] = up + left;
    }
}
