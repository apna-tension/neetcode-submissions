class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int ans = coin(coins, 0, amount, 0);
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    private int coin(int[] coins, int i, int target, int count) {
        if (target == 0) return count;

        if (i >= coins.length) return Integer.MAX_VALUE;

        int take = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;
        if (coins[i] <= target) take = coin(coins, i, target-coins[i], count+1);
        skip = coin(coins, i+1, target, count);
        return Math.min(take, skip);
    }
}
