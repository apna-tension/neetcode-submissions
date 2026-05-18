class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];

        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length-1) {
                arr1[i] = nums[i];
            }
            if (i != 0) {
                arr2[i-1] = nums[i];
            }
        }

        // int first = max(arr1, 0, dp);
        int first = tab(arr1);
        // dp = new int[nums.length];
        // int last = max(arr2, 0, dp);
        int last = tab(arr2);
        return Math.max(first, last);
    }

    private int tab(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    private int max(int nums[], int i, int dp[]) {
        if (i >= nums.length) return 0;

        if (dp[i] != 0) return dp[i];
        int take = max(nums, i+2, dp);

        int nontake = max(nums, i+1, dp);

        return dp[i] = Math.max(nums[i] + take, nontake);
    }
}
