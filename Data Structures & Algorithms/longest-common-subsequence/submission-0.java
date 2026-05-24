class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return seq(text1, 0, text2, 0, dp);
    }

    private int seq(String str1, int i, String str2, int j, int[][] dp) {
        if (i >= str1.length() || j >= str2.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        int take = 0;
        if (str1.charAt(i) == str2.charAt(j)) {
            take = 1 + seq(str1, i+1, str2, j+1, dp);
        }

        int notTake = Math.max(seq(str1, i+1, str2, j, dp), seq(str1, i, str2, j+1, dp));
        return dp[i][j] = Math.max(take, notTake);
    }
}
