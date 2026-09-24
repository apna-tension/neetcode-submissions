class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(rec(cost, cost.length-1, dp), rec(cost, cost.length-2, dp));
    }

    private int rec(int[] cost, int i, int[] dp) {
        if (i < 0) return 0;

        if (dp[i] != -1) return dp[i];
        return dp[i] = cost[i] + Math.min(rec(cost, i-2, dp), rec(cost, i-1, dp));
    }
}
