class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]);
                }
            }
        }

        for (Integer[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }

        return dp[m-1][n-1];
        // return path(m-1, n-1, m, n, dp);
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
