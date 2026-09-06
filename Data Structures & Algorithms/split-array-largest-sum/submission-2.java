class Solution {
    public int splitArray(int[] nums, int k) {
        int[][] dp = new int[k+1][nums.length+1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return split(nums, k, 0, dp);
    }

    private int split(int[] num, int k, int i, int[][] dp) {
        if (i == num.length) {
            return k == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (k == 0) return Integer.MAX_VALUE;

        if (dp[k][i] != -1) return dp[k][i];

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int j = i; j < num.length; j++) {
            sum += num[j];
            min = Math.min(min, Math.max(sum, split(num, k-1, j+1, dp)));
            if (sum > min) break;
        }
        return dp[k][i] = min;
    }
}