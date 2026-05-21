class Solution {
    public int lengthOfLIS(int[] nums) {
        return len(nums, 0, -1, new int[nums.length][nums.length+1]);
    }
    private int len(int[] nums, int i, int j, int[][] dp) {
        if (i >= nums.length) return 0;

        if (j != -1 && dp[i][j+1] != 0) return dp[i][j+1];
        int take = 0;
        if (j == -1 || nums[i] > nums[j]) take = 1 + len(nums, i+1, i, dp);
        return dp[i][j+1] = Math.max(take, len(nums, i+1, j, dp));
    }
}
